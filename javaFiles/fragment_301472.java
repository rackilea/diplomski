public class CameraCatcher {

    public native long initCamera(String ip, String port, String username, String pwd);

    public native int snapPic(long id, String savePath, int no);

    static {
        System.load("/home/tarik/NetBeansProjects/Testc++/dist/test.so");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CameraCatcher tNative = new CameraCatcher();
        String ip = "192.108.1.108";
        String port = "37777";
        String username = "admin";
        String pwd = "123456";
        long cameraId = tNative.initCamera(ip, port, username, pwd);
        System.out.println(cameraId);
        String savePath = "D:/";
        int number = tNative.snapPic(cameraId, savePath, 0);
        System.out.println(number);
    }
}