public class DesktopWallpaperHandler extends Unknown{
    private static final GUID CLSID_DesktopWallpaper = new GUID("{C2CF3110-460E-4fc1-B9D0-8A1C0C9CC4BD}");
    private static final GUID IID_IDesktopWallpaper = new GUID("{B92B56A9-8B55-4E14-9A89-0199BBB6F93B}");

    private DesktopWallpaperHandler(Pointer pvInstance) {
        super(pvInstance);
    }

    public static DesktopWallpaperHandler create(){
        PointerByReference p = new PointerByReference();

        WinNT.HRESULT hr = Ole32.INSTANCE.CoCreateInstance(CLSID_DesktopWallpaper, null, WTypes.CLSCTX_SERVER, IID_IDesktopWallpaper, p);
        COMUtils.checkRC(hr);

        DesktopWallpaperHandler handler = new DesktopWallpaperHandler(p.getValue());

        return handler;
    }

    public void SetWallpaper(WTypes.LPWSTR monitor, WTypes.LPWSTR wallpaper){
        int result = this._invokeNativeInt(3, new Object[]{this.getPointer(), monitor, wallpaper});
        COMUtils.checkRC(new HRESULT(result));
    }
}