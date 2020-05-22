Path path = Paths.get("/path/to/your/module");

ModuleFinder finder = ModuleFinder.of(path);
ModuleLayer parent = ModuleLayer.boot();

Configuration configuration = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of(moduleName));
ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

ModuleLayer layer = parent.defineModulesWithOneLoader(configuration, systemClassLoader);
Module m = layer.findModule(moduleName).orElse(null);