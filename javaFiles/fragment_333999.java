// src\sun.day\my\options\Options.java
package my.options;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import java.lang.module.ModuleReference;
import java.lang.module.ModuleReader;
import java.lang.module.Configuration;

import java.net.URI;
import java.io.IOException;


public class Options {

  // main
  public static void main(String[] args) throws Exception{
    System.out.println();

    Options options = new Options();

    System.out.println("-- directoryMap -- ");
    options.printMap(options.resolvedModuleSourceMap("sun.day"));
  }

  // toString
  public String toString(){
    return "I'm Options";
  }

  // printMap
  <K,V> void printMap(Map<K,Set<V>> map) {
    for (Map.Entry<K,Set<V>> entry : map.entrySet()) {
      System.out.println(entry.getKey());
      entry.getValue().stream().forEach(c -> System.out.println("  " + c));
    }
  }

  // resolvedModuleSourceMap
  Map<String,Set<Class<?>>> resolvedModuleSourceMap(String moduleName){
    // use ModuleLayer.boot().configuration().modules() if moduleName is empty in a recursive approach.

    Configuration parent = ModuleLayer.boot().configuration();
    ModuleReader moduleReader = null;
    Set<String> resources = null;

    ModuleReference moduleReference =
      parent.findModule(moduleName)              // Optional<ResolvedModule>
            .stream()                            // Stream<ResolvedModule>
            .map(resMod -> resMod.reference())   // Stream<ModuleReference>
            .findAny()                           // Optional<ModuleReference>
            .orElse(null);

    try {
      moduleReader = moduleReference.open();
      resources = moduleReader.list()                                        // Stream<String>
                              .filter(s -> s.contains("."))                  // no directories: "my/", "my/options/"
                              .filter(s -> !s.equals("module-info.class"))   // remove 
                              .collect(Collectors.toSet());
    } catch (IOException ex) {
      System.out.println("Ooops! tryResolvedModuleLocation has this ERROR: " + ex);
    }

//    System.out.println("-- resources -- ");
//    System.out.println(resources);

    Map<String,Set<Class<?>>> directoryMap = new HashMap<>();
    for (String s : resources) {
      try {
            Optional<URI> opt = moduleReader.find(s);
            if (opt != null & opt.isPresent()) {
              String key = opt.stream()
                              .map(uri -> uri.toString())
                              .map(str -> str.replaceAll("("+s+")|(file:/)|(//)",""))
                              .findAny()
                              .get();
              Set<Class<?>> set = directoryMap.get(key);
              if (set == null) {
                set = new HashSet<>();
                directoryMap.put(key,set);
              }
              set.add(Class.forName(s.replace("/",".").replace(".class","")));
            }
          } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Ooops! tryResolvedModuleLocation has this ERROR: " + ex);
          }
    }

//    System.out.println("-- directoryMap -- ");
//    System.out.println(directoryMap);
    return directoryMap;
  }

  // printCompareClassLoader
  void printCompareClassLoader(ClassLoader otherClassLoader){
    System.out.println();
    System.out.println("this  = " + this.getClass().getClassLoader());
    System.out.println("other = " + otherClassLoader);
    if (this.getClass().getClassLoader() == otherClassLoader) {
      System.out.println(" references are identical");
    } else {
      System.out.println(" references are NOT identical");
    }
  }
}