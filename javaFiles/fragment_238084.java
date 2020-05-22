package com.jimtough;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.micromata.opengis.kml.v_2_2_0.Kml;

/**
 * Uses the classes in java.util.zip to package a KML file and its
 * supplementary files as a ZIP-compressed KMZ file.
 * 
 * @author JTOUGH
 */
public final class KMZPackager {

    private final static Logger logger =
        LoggerFactory.getLogger(KMZPackager.class);

    /**
     * Container for data that represents a single entry that will be added
     * to a compressed archive.
     * @author JTOUGH
     */
    public static abstract class DataSource {
        protected String archivedFileName;

        /**
         * Write the contents of this data source to the supplied
         * zip output stream.
         * 
         * @param zipOutputStream
         * @throws IOException
         */
        public abstract void writeToStream(ZipOutputStream zipOutputStream) 
            throws IOException; 
    }

    /**
     * Container for data that represents a single file that will be added
     * to a compressed archive.
     * @author JTOUGH
     */
    public static final class FileDataSource extends DataSource {
        private File sourceFile;

        /**
         * Constructor
         * 
         * @param sourceFile Actual file that will be added to the 
         *  compressed archive. 
         * @param archivedFileName Name that will be assigned to the compressed
         *  file within the archive. Caller must ensure that this value is
         *  unique within the archive otherwise an exception will be thrown
         *  when a name clash occurs during creation of the archive.
         *  This string must be non-null and non-empty. Any forward-slash
         *  characters in the string will be treated as directory separators
         *  when the KMZ/ZIP archive is created.
         * @throws IllegalArgumentException If either of these parameters
         *  is a null reference
         */
        public FileDataSource(
                File sourceFile,
                String archivedFileName) 
                throws IllegalArgumentException {
            Validate.notNull(sourceFile);
            Validate.notEmpty(archivedFileName);
            this.sourceFile = sourceFile;
            this.archivedFileName = archivedFileName;
        }

        @Override
        public void writeToStream(ZipOutputStream zipOutputStream)
                throws IOException {
            Validate.notNull(zipOutputStream);

            // Check that the file exists, and throw an appropriate exception
            // before reading it
            if (!sourceFile.exists()) {
                throw new IllegalArgumentException(
                    "File referenced in parameter [" +
                    sourceFile.getAbsolutePath() + "] does not exist");
            }

            FileInputStream fis = new FileInputStream(sourceFile);

            if (logger.isDebugEnabled()) {
                logger.debug("Adding file to KMZ archive" +
                    " | archive name: " + archivedFileName +
                    " | original name: " + 
                    sourceFile.getCanonicalPath());
            }

            // Mark the start of this new file in the ZIP stream
            ZipEntry entry = new ZipEntry(archivedFileName);
            zipOutputStream.putNextEntry(entry);

            // Use the Apache commons-io library to do a buffered
            // stream-to-stream copy
            try {
                IOUtils.copy(fis, zipOutputStream);
            } finally {
                fis.close();
            }
        }
    }

    /**
     * Container for a single JAK Kml object that will be marshalled
     * directly to a compressed KMZ archive as it is created
     * @author JTOUGH
     */
    public static final class KMLDataSource extends DataSource {
        private Kml kml;

        /**
         * Constructor
         * 
         * @param kml JAK Kml object that will be marshalled directly to the 
         *  compressed archive. 
         * @param archivedFileName Name that will be assigned to the compressed
         *  file within the archive. Caller must ensure that this value is
         *  unique within the archive otherwise an exception will be thrown
         *  when a name clash occurs during creation of the archive.
         *  This string must be non-null and non-empty. Any forward-slash
         *  characters in the string will be treated as directory separators
         *  when the KMZ/ZIP archive is created.
         * @throws IllegalArgumentException If either of these parameters
         *  is a null reference
         */
        public KMLDataSource(
                Kml kml,
                String archivedFileName) 
                throws IllegalArgumentException {
            Validate.notNull(kml);
            Validate.notEmpty(archivedFileName);
            this.kml = kml;
            this.archivedFileName = archivedFileName;
        }

        @Override
        public void writeToStream(ZipOutputStream zipOutputStream) throws IOException {
            Validate.notNull(zipOutputStream);
            // Mark the start of this new file in the ZIP stream
            ZipEntry entry = new ZipEntry(archivedFileName);
            zipOutputStream.putNextEntry(entry);

            // Marshal the Kml object directly to the ZipOutputStream
            if (logger.isDebugEnabled()) {
                logger.debug("Marshalling KML to KMZ archive" +
                    " | archive name: " + archivedFileName);
            }
            kml.marshal(zipOutputStream);   
        }
    }

    /**
     * Container for a stream holding a Kml document. This will be written
     * directly to a compressed KMZ archive as it is created.
     */
    public static final class StreamDataSource extends DataSource {

        private InputStream inputStream;

        /**
         * Constructor
         * 
         * @param inputStream the inputStream holding the KML text
         * @param archivedFileName Name that will be assigned to the compressed
         *  file within the archive. Caller must ensure that this value is
         *  unique within the archive otherwise an exception will be thrown
         *  when a name clash occurs during creation of the archive.
         *  This string must be non-null and non-empty. Any forward-slash
         *  characters in the string will be treated as directory separators
         *  when the KMZ/ZIP archive is created.
         * @throws IllegalArgumentException If either of these parameters
         *  is a null reference
         */
        public StreamDataSource(
                InputStream inputStream,
                String archivedFileName) 
                throws IllegalArgumentException {
            Validate.notNull(inputStream);
            Validate.notEmpty(archivedFileName);
            this.inputStream = inputStream;
            this.archivedFileName = archivedFileName;
        }

        @Override
        public void writeToStream(ZipOutputStream zipOutputStream) throws IOException {
            Validate.notNull(zipOutputStream);
            // Mark the start of this new file in the ZIP stream
            ZipEntry entry = new ZipEntry(archivedFileName);
            zipOutputStream.putNextEntry(entry);

            // Use the Apache commons-io library to do a buffered
            // stream-to-stream copy
            if (logger.isDebugEnabled()) {
                logger.debug("Copying KML from stream to KMZ archive" +
                    " | archive name: " + archivedFileName);
            }
            try {
                IOUtils.copy(inputStream, zipOutputStream);
            } finally {
                inputStream.close();
            }
        }
    }

    /**
     * Use ZIP compression to package a KML file and its supplementary files
     * as a KMZ archive.  The compressed archive will be written to the 
     * supplied output stream.
     * 
     * @param os OutputStream to which the compressed archive will be written.
     *  This parameter must be a non-null reference to an OutputStream that
     *  is open for write operations.
     * @param kmlDataSource KML to be added to the compressed archive. 
     *  This parameter must not be null. The archivedFileName attribute must
     *  end with the .kml extension. The file is added to the compressed 
     *  archive. The KMZ specification states that a KMZ archive must only
     *  contain a single KML file.
     * @param supplementaryFileList List of file locations for supplementary
     *  files that will be included in the KMZ archive. A common example
     *  would be icons or image overlays that are referenced in the KML file.
     *  This parameter can be null or an empty list if there are no 
     *  supplementary files to include in the KMZ. Each source that is included
     *  in the list must refer to an existing file that does NOT have the
     *  file extension '.kml'.
     * @throws RuntimeException Thrown if anything unexpected occurs
     *  that prevents execution from continuing or if any of the stated
     *  conditions for the input parameters are violated
     */
    public void packageAsKMZ(
            OutputStream os,
            DataSource kmlDataSource,
            List<FileDataSource> supplementaryFileList) 
            throws RuntimeException {
        ZipOutputStream zipOutputStream = null;
        boolean isExceptionThrown = false;
        Exception caughtException = null;
        List<FileDataSource> supplFileList = supplementaryFileList;

        try {
            Validate.notNull(os, "os parameter cannot be null");
            Validate.notNull(kmlDataSource, 
                "kmlFileDataSource parameter cannot be null");

            // Treat a null parameter just like an empty list (which is OK)
            if (supplFileList == null) {
                supplFileList = Collections.emptyList();
            }

            if (logger.isDebugEnabled()) {
                logger.debug(
                    "Creating KMZ archive" +
                    " | supplementary files: " + supplFileList.size());
            }

            // Create a buffered output stream for the new KMZ file
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(os));
            Validate.isTrue(
                kmlDataSource.archivedFileName.endsWith(".kml"),
                "KML archived file name must end with .kml");
            kmlDataSource.writeToStream(zipOutputStream);

            // Now process the list of supplementary files
            if (logger.isDebugEnabled()) {
                logger.debug("Adding supplementary files to KMZ archive" +
                    " | archive name: ");
            }
            for (FileDataSource ds : supplFileList) {
                Validate.isTrue(
                    !ds.archivedFileName.endsWith(".kml"),
                    "Not legal to include .kml files in supplementary list");
                ds.writeToStream(zipOutputStream);
            }

            // Close the output stream to complete the ZIP creation
            zipOutputStream.flush();
            zipOutputStream.close();

            logger.info("KMZ archive created successfully");

        } catch (IOException e) {
            isExceptionThrown = true;
            caughtException = e;
            logger.error("IOException while creating ZIP stream");
        } catch (IllegalArgumentException e) {
            isExceptionThrown = true;
            caughtException = e;
        } catch (RuntimeException e) {
            isExceptionThrown = true;
            caughtException = e;
        } finally {
            if (isExceptionThrown) {
                try {
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                } catch (IOException ioe) {
                    // Don't care
                }
                throw new RuntimeException(caughtException);
            }
        }
    }
}