Ole32.INSTANCE.CoInitializeEx(Pointer.NULL, Ole32.COINIT_MULTITHREADED);
try {
    WTypes.LPWSTR path = new LPWSTR("C:\\Users\\Harry\\Desktop\\1.jpg");
    DesktopWallpaperHandler handler = DesktopWallpaperHandler.create();
    handler.SetWallpaper(null, path);
} finally {
    Ole32.INSTANCE.CoUninitialize();
}