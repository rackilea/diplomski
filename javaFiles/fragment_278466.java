public interface MyLib extends StdCallLibrary {
    MyLib INSTANCE = (MyLib) Native.loadLibrary("MyLib", MyLib.class);
    int GetText(byte[] lpText, int len);
}

....

int len = User32.INSTANCE.GetText(null);
byte[] arr = new byte[len];
User32.INSTANCE.GetText(arr, len);
String Text = Native.toString(arr);