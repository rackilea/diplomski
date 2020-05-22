public static String friendlyFileSize(long size) {
    String unit = "bytes";
    if(size > 1024) {
        size = size / 1024; 
        unit = "kb";
    }

    if(size > 1024) {
        size = size / 1024; 
        unit = "mb";
    }

    if(size > 1024) {
        size = size / 1024; 
        unit = "gb";
    }
    return size + " " + unit;
}