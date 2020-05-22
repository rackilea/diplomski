public class BitmapScreencap {
    public final static BitmapScreencap Get = new BitmapScreencap();
    private BitmapScreencap() { }
    public Bitmap Screen() {
        try {
            Process process = Runtime.getRuntime().exec("su");
            OutputStreamWriter outputStream = new OutputStreamWriter(process.getOutputStream());
            outputStream.write("/system/bin/screencap -p\n");
            outputStream.flush();
            Bitmap screen = BitmapFactory.decodeStream(process.getInputStream());
            outputStream.write("exit\n");
            outputStream.flush();
            outputStream.close();
            return screen;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}