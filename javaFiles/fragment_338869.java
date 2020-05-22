// Java defaults unspecified type arguments to Object.
fileHandler<Object, Object> file;

if (...) {
   // Error: fileHandler<String, String> is not equivalent to fileHandler<Object, Object>
   file = new fileHandler<String, String>();
} else {
   // Error: fileHandler<String, String[]> is not equivalent to fileHandler<Object, Object>
   file = new fileHandler<String, String[]>();
}