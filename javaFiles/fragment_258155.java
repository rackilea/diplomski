import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import java.util.*;
import java.util.stream.Collectors;

private static Collection<String> getListPackageNames(String pMainPackage) {
    List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
    classLoadersList.add(ClasspathHelper.contextClassLoader());
    classLoadersList.add(ClasspathHelper.staticClassLoader());

    Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
            .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
            .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(pMainPackage))));
    // Get all classes
    Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
    // Get all packages of those classes while removing duplicate
    final Set<Package> listClassPackages = classes.stream().map(c -> c.getPackage()).collect(Collectors.toSet());

    // Extract package name while loving up to get the intermediate packages.
    final Set<String> listPackageNames = new HashSet<>();
    for (Package classPackage:listClassPackages) {
        String packageName = classPackage.getName();
        while (!packageName.equals(pMainPackage)) {
            // Add it to the list
            listPackageNames.add(packageName);
            // Then move up
            final int index = packageName.lastIndexOf('.');
            packageName = packageName.substring(0, index);
        }
    }
    return listPackageNames;
}