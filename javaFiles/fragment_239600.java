public  class  GlobalVariables extends Application {
private static Boolean _IsIOIORunning=false;
private static  Boolean _FileUploading=false;

public static Boolean get_IsIOIORunning() {
    return _IsIOIORunning;
}

public static void set_IsIOIORunning(Boolean _IsIOIORunning) {
    GlobalVariables._IsIOIORunning = _IsIOIORunning;
}

public static Boolean get_FileUploading(){
    return _FileUploading;
}

public static void set_FileUploading(Boolean _FileUploading){
    GlobalVariables._FileUploading = _FileUploading;
}
}