Python py = Python.getInstance();
PyObject mod = py.getModule("mod");

// If the function knows what methods and attributes to use, Java objects
// can be passed directly.
mod.callAttr("f", someJavaObject);

// If the function expects an iterable, Java arrays can be passed directly.
mod.callAttr("f", new String[] {"one", "two", "three"});

// If the function expects a dict, it can be created as follows.
PyObject builtins = py.getBuiltins();
PyObject d = builtins.callAttr("dict");
d.callAttr("__setitem__", 1, "a");
d.callAttr("__setitem__", 2, "b");
mod.callAttr("f", d);