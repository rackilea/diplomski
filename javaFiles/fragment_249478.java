import grails.util.Holders;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FileUtils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

public class ImageService {
    static final String[] OPENCV_SUPPORTED_EXTENSION = new String[]{"bmp", "dib", "jp2", "jpe", "jpeg", "jpg", "pbm", "pgm", "png", "ppm", "ras", "sr", "tif", "tiff"};

    public static File cropImage(final File originalFile) {
        loadLibrary();
        return cropImage(originalFile, originalFile.getParentFile(), getCascadeClassifiers());
    }

    public static File cropImage(final File originalFile, final ArrayList<CascadeClassifier> cascadeClassifiers) {
        return cropImage(originalFile, originalFile.getParentFile(), cascadeClassifiers);
    }

    public static File cropImage(final File originalFile, final File targetDirectory) {
        loadLibrary();
        return cropImage(originalFile, originalFile.getParentFile(), getCascadeClassifiers());
    }

    public static File cropImage(final File originalFile, final File targetDirectory, final ArrayList<CascadeClassifier> cascadeClassifiers) {
        ArrayList<File> siblingFiles = getFaces(originalFile, cascadeClassifiers);
        File maxFile = null;
        int maxWidth = 0;

        for(int x = 0; x < siblingFiles.size(); x++) {
            Mat image = Imgcodecs.imread(siblingFiles.get(x).getAbsolutePath(), Imgcodecs.IMREAD_UNCHANGED);

            if(image.width() > maxWidth) {
                maxFile = siblingFiles.get(x);
                maxWidth = image.width();
            }
        }

        File croppedFile = null;
        if(maxFile != null) {
            croppedFile = new File(targetDirectory.getAbsolutePath() +
                File.separator +
                originalFile.getName());

            try {
                FileUtils.copyFile(maxFile, croppedFile);
            }
            catch(IOException e) {}
        }

        for(int y = 0; y < siblingFiles.size(); y++) {
            siblingFiles.get(y).delete();
        }

        System.gc();
        System.runFinalization();

        return croppedFile;
    }

    public static ArrayList<CascadeClassifier> getCascadeClassifiers() {
        ArrayList<CascadeClassifier> classifiers = new ArrayList<CascadeClassifier>();

        final String[] cascadeSupportedExtensions = new String[]{"xml"};
        final String cascadeClassifierPath = Holders.getFlatConfig().get("openCV.cascadeClassifiers").toString();
        File cascadeClassifierDirectory = new File(cascadeClassifierPath);
        ArrayList<File> detectors = new ArrayList<File>(FileUtils.listFiles(cascadeClassifierDirectory, cascadeSupportedExtensions, false));

        for(int y = 0; y < detectors.size(); y++) {
            CascadeClassifier faceDetector = new CascadeClassifier();
            faceDetector.load(detectors.get(y).getAbsolutePath());

            classifiers.add(faceDetector);
        }

        return classifiers;
    }

    public static ArrayList<File> getFaces(final File originalFile) {
        loadLibrary();
        return getFaces(originalFile, getCascadeClassifiers());
    }

    public static ArrayList<File> getFaces(final File originalFile, final ArrayList<CascadeClassifier> cascadeClassifiers) {
        File temporaryFile = new File(originalFile.getParentFile().getAbsolutePath() +
            File.separator +
            UUID.randomUUID().toString() +
            "." + FilenameUtils.getExtension(originalFile.getName()));

        try {
            FileUtils.copyFile(originalFile, temporaryFile);
        }
        catch(IOException e) {}

        final int frame = 9;
        final int offset = 8;
        int rotateCounter = 0;

        Integer marginX, marginY, marginWidth, marginHeight;
        Integer pxPerOffset, excess;

        ArrayList<File> siblingFiles = new ArrayList<File>();

        while(rotateCounter < 4) {
            if(rotateCounter > 0) {
                Mat image = Imgcodecs.imread(temporaryFile.getAbsolutePath(), Imgcodecs.IMREAD_UNCHANGED);

                Core.transpose(image, image);
                Core.flip(image, image, 1);

                Imgcodecs.imwrite(temporaryFile.getAbsolutePath(), image);

                image.release();
            }

            for(int y = 0; y < cascadeClassifiers.size(); y++) {
                CascadeClassifier faceDetector = cascadeClassifiers.get(y);
                Mat image = Imgcodecs.imread(temporaryFile.getAbsolutePath(), Imgcodecs.IMREAD_UNCHANGED);

                MatOfRect faceDetections = new MatOfRect();
                faceDetector.detectMultiScale(image, faceDetections);

                Rect defaultRect = null;
                Rect marginRect = null;
                Rect[] facesRect = faceDetections.toArray();

                for(int z = 0; z < facesRect.length; z++) {
                    defaultRect = facesRect[z];
                    pxPerOffset = defaultRect.width / frame;

                    marginX = defaultRect.x - (pxPerOffset * offset);
                    marginY = defaultRect.y - (pxPerOffset * offset);

                    marginWidth = defaultRect.width + (offset * pxPerOffset * 2);
                    marginHeight = defaultRect.height + (offset * pxPerOffset * 2);

                    excess = Math.max(
                        0 - marginX,
                            Math.max(0 - marginY,
                                Math.max(marginX + marginWidth - image.width(),
                                    Math.max(marginY + marginHeight - image.height(), 0)))
                    );

                    if(excess > 0) {
                        marginX += excess;
                        marginY += excess;

                        marginWidth -= excess * 2;
                        marginHeight -= excess * 2;
                    }

                    marginRect = new Rect(marginX, marginY, marginWidth, marginHeight);
                    Mat imageWithMargin = new Mat(image, marginRect);

                    String croppedFileName = temporaryFile.getParentFile().getAbsolutePath() +
                        File.separator +
                        UUID.randomUUID().toString() + "_" +
                        y + "_" +
                        rotateCounter + "_" +
                        z + "." +
                        FilenameUtils.getExtension(temporaryFile.getName());

                    Imgcodecs.imwrite(croppedFileName, imageWithMargin);

                    siblingFiles.add(new File(croppedFileName));

                    imageWithMargin.release();
                }

                image.release();
            }

            rotateCounter++;
        }

        temporaryFile.delete();

        return siblingFiles;
    }

    public static void loadLibrary() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        final String[] urls = new String[]{
            Holders.getFlatConfig().get("openCV.java").toString(),
            Holders.getFlatConfig().get("openCV.home").toString()
        };

        final String[] validExtensions = new String[]{"dll"};
        ArrayList<File> dlls = new ArrayList<File>();
        for(int y = 0; y < urls.length; y++) {
            dlls.addAll(FileUtils.listFiles(new File(urls[y]), validExtensions, false));
        }

        for(int y = 0; y < dlls.size(); y++) {
            for(int z = 0; z < validExtensions.length; z++) {
                System.loadLibrary(dlls.get(y).getName().replace("." + validExtensions[z], ""));
                System.load(dlls.get(y).getAbsolutePath());
            }
        }
    }
}