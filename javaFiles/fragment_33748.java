PyObject pyObject = ...;
// Set attribute: setattr(obj, name, value)
//            OR: obj.__setattr__(name, value)
PyString attrName = Py.newString("some_attribute");
PyObject attrValue = (PyObject)Py.newString("A string as the new value.");
pyObject.__setattr__(attrName, attrValue);