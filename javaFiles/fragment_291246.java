// get an instance of the native C++ class
static native long getClassInstance();

static native long getClassInstance( long file );

// get the native FILE * from the class instance
static native long getFileFromClass( long cls );

// close the FILE *
static native void closeFile( long file );