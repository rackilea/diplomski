import java.io.File;
import java.util.Collection;

import org.apache.commons.io.*;
import org.apache.commons.io.filefilter.*;

public class SearchDocFiles {
    public static String[] EXTENSIONS = { "doc", "docx" };

    public Collection<File> searchFilesWithExtensions(final File directory, final String[] extensions) {
        return FileUtils.listFiles(directory,
                extensions,
                true);
    }

    public Collection<File> searchFilesWithCaseInsensitiveExtensions(final File directory, final String[] extensions) {
        IOFileFilter fileFilter = new SuffixFileFilter(extensions, IOCase.INSENSITIVE);
        return FileUtils.listFiles(directory,
                fileFilter,
                DirectoryFileFilter.INSTANCE);
    }


    public static void main(String... args) {
        // Case sensitive
        Collection<File> documents = new SearchDocFiles().searchFilesWithExtensions(
                new File("/tmp"),
                SearchDocFiles.EXTENSIONS);
        for (File document: documents) {
            System.out.println(document.getName() + " - " + document.length());
        }

        // Case insensitive
        Collection<File> caseInsensitiveDocs = new SearchDocFiles().searchFilesWithCaseInsensitiveExtensions(
                new File("/tmp"),
                SearchDocFiles.EXTENSIONS);
        for (File document: caseInsensitiveDocs) {
            System.out.println(document.getName() + " - " + document.length());
        }
    }
}