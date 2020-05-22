import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.W32APIOptions;
import java.io.IOException;


public class FileVersionInfo
{
    interface Version extends Library {

        Version INSTANCE = (Version) Native.loadLibrary("Version", Version.class, W32APIOptions.UNICODE_OPTIONS);

        public int GetFileVersionInfoSizeW(String lptstrFilename, int dwDummy);

        public boolean GetFileVersionInfoW(String lptstrFilename, int dwHandle,
            int dwLen, Pointer lpData);

        public int VerQueryValueW(Pointer pBlock, String lpSubBlock,
            PointerByReference lplpBuffer, IntByReference puLen);

    }

    static class VS_FIXEDFILEINFO extends com.sun.jna.Structure {
        public int dwSignature;
        public int dwStrucVersion;
        public int dwFileVersionMS;
        public int dwFileVersionLS;
        public int dwProductVersionMS;
        public int dwProductVersionLS;
        public int dwFileFlagsMask;
        public int dwFileFlags;
        public int dwFileOS;
        public int dwFileType;
        public int dwFileSubtype;
        public int dwFileDateMS;
        public int dwFileDateLS;

           public VS_FIXEDFILEINFO(com.sun.jna.Pointer p){
                super(p);
           }
    }
    public static void main(String[] args) throws IOException {

        int dwDummy = 0;
        int versionlength = Version.INSTANCE.GetFileVersionInfoSizeW(
                "C:\\Test\\chromeinstall.exe", dwDummy);

        byte[] bufferarray = new byte[versionlength];
        Pointer lpData = new Memory(bufferarray.length);    

        PointerByReference lplpBuffer = new PointerByReference();
        IntByReference puLen = new IntByReference();
        boolean FileInfoResult = Version.INSTANCE.GetFileVersionInfoW(
                "C:\\Test\\chromeinstall.exe",
                0, versionlength, lpData);
        System.out.println(FileInfoResult);
        int verQueryVal = Version.INSTANCE.VerQueryValueW(lpData,
                "\\", lplpBuffer,
                puLen);

        VS_FIXEDFILEINFO lplpBufStructure = new VS_FIXEDFILEINFO(
                lplpBuffer.getValue());
        lplpBufStructure.read();

        short[] rtnData = new short[4];
        rtnData[0] = (short) (lplpBufStructure.dwFileVersionMS >> 16);
        rtnData[1] = (short) (lplpBufStructure.dwFileVersionMS & 0xffff);
        rtnData[2] = (short) (lplpBufStructure.dwFileVersionLS >> 16);
        rtnData[3] = (short) (lplpBufStructure.dwFileVersionLS & 0xffff);

        for (int i = 0; i < rtnData.length; i++) {
            System.out.println(rtnData[i]);
        }

}