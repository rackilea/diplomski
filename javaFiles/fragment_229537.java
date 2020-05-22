// Define the mime type detector to use, here it will be MagicMimeMimeDetector
// As you intend to detect from a Stream
// To be done only once in a static block of your class for example    
MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
...
// Get the collection of matching mime types
Collection<?> mimeTypes = MimeUtil.getMimeTypes(stream);