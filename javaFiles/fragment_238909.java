import java.lang.ClassLoader;
import java.net.URLClassLoader;
import java.net.URL;

def showObjectClassLoaderHierarchy(Object obj) {
        def classLoader = showClassLoaderHierarchy(obj.getClass().getClassLoader());
        showClassLoaderHierarchy(classLoader);
}

def showClassLoaderHierarchy(ClassLoader loader) {

        if (loader != null) {
            println "Classloader: " + loader.hashCode();
            while (loader.getParent() != null) {
                  loader = loader.getParent();
                  println "    Child of: " + loader.hashCode();
            }
        }

}

println "Setting up child classLoaders A and B...";

def URL[] urlsA = [new URL("file:///tmp/cla/")];
def classLoaderA = new URLClassLoader(urlsA, this.getClass().getClassLoader());

def URL[] urlsB = [new URL("file:///tmp/clb/")];
def classLoaderB = new URLClassLoader(urlsB, this.getClass().getClassLoader());


println "Classloader A heirachry:";
showClassLoaderHierarchy(classLoaderA);

println "Classloader B: ";
showClassLoaderHierarchy(classLoaderB);

println "";
println "Now loading Load classes A and B from seperate classloaders:";
def loadA = classLoaderA.loadClass("LoadA").newInstance();
def loadB = classLoaderB.loadClass("LoadB").newInstance();

print "LoadA: heirachry";
showObjectClassLoaderHierarchy(loadA);
print "LoadB: heirachry";
showObjectClassLoaderHierarchy(loadB);

println "";
println "Now pulling the data objects from both and comparing classloders and static data: ";
def dobjA = loadA.getDataObj();
def dobjB = loadB.getDataObj();

println "dataA static field:" + dobjA.getData();
println "dataA static field hashcode: " + dobjA.getData().hashCode();
println "dataA hashcode: " + dobjA.hashCode();
println "dataA classloader: ";
showObjectClassLoaderHierarchy(dobjA);

println "dataB static field: " + dobjB.getData();
println "dataB static field hashcode: " + dobjB.getData().hashCode();
println "dataB hashcode: " + dobjB.hashCode();
println "dataB classLoader:";
showObjectClassLoaderHierarchy(dobjB);