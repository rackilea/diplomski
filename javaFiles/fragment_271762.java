import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.AntPathMatcher;

/**
 * Package utility. Provides handy methods for finding classes (of a particular
 * type) within a package on the classpath.
 * 
 * @author cphillipson
 * 
 * @param <T>
 *            types of classes to be found in package
 */
class PackageUtil<T> {

public List<Class<T>> listMatchingClasses(String matchPattern) throws IOException {
    final List<Class<T>> classes = new LinkedList<Class<T>>();
    final PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
    scanner.setPathMatcher(new AntPathMatcher());
    final Resource[] resources = scanner.getResources("classpath:" + matchPattern);
    for (final Resource resource : resources) {
        final Class<T> clazz = getClassFromResource(resource);
        classes.add(clazz);
    }
    return classes;
}

public Class<T> getClassFromResource(Resource resource) {
    Class<T> result = null;
    try {
        String resourceUri = resource.getURI().toString();
        resourceUri = resourceUri.substring(0, resourceUri.indexOf(".class")).replace("/", ".");
        if (resourceUri.contains("!")) { // class was found in an archive
            resourceUri = resourceUri.substring(resourceUri.indexOf("!") + 2);
        }
        // try printing the resourceUri before calling forName, to see if it
        // is OK.
        result = (Class<T>) Class.forName(resourceUri);
    } catch (final Exception ex) {
        ex.printStackTrace();
    }
    return result;
}
}


/**
* A collection of special-purposed methods for working with files and
* directories. Wraps Apache Commons I/O.
* 
* @author cphillipson
* 
*/
public class FileUtil {

public static Collection<File> getAllJavaSourceInDirectory(File directory, boolean recursive) {
    // scans directory (and sub-directories if recursive flag is true) for
    // .java files, returns a collection of files
    return FileUtils.listFiles(directory, new String[] { "java" }, recursive);
}

public static boolean isContentInFile(File file, String fragment) throws IOException {
    boolean result = false;
    final String contents = toString(file);
    if (contents.contains(fragment)) { // does file contain fragment?
        result = true;
    }
    return result;
}

public static String toString(File file) throws IOException {
    final String result = FileUtils.readFileToString(file, "utf8");
    return result;
}

public static void toFile(File file, String content) throws IOException {
    FileUtils.writeStringToFile(file, content, "utf8");
}
}