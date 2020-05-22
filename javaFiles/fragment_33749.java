PyObject pyObject = ...;

// Get method: method = getattr(obj, name)
//         OR: method = obj.__getattr__(name)
PyString methodName = Py.newString("some_method");
PyObject pyMethod = pyObject.__getattr__(methodName);

// Prepare arguments.
// NOTE: args contains positional arguments followed by keyword argument values.
PyObject[] args = new PyObject[] {arg1, arg2, ..., kwarg1, kwarg2, ...};
String[] keywords = new String[] {kwname1, kwname2, ...};

// Call method: result = method(arg1, arg2, ..., kwname1=kwarg1, kwname2=kwarg2, ...)
PyObject pyResult = pyMethod.__call__(args, keywords);