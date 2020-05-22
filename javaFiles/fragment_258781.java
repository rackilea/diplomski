public class Client {

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    while (true) {
        String fileName = sc.nextLine();
        System.out.println(fileName);
        try {
            File file = new File(fileName);

            byte[] mybytearray = new byte[1 + fileName.getBytes().length + (int) file.length()];
            mybytearray[0] = (byte) fileName.length();

            System.arraycopy(fileName.getBytes(), 0, mybytearray, 1, fileName.getBytes().length);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            bis.read(mybytearray, fileName.getBytes().length + 1, (int) file.length());

            Socket socket = new Socket("localhost", 15000);
            OutputStream os = socket.getOutputStream();

            os.write(mybytearray, 0, mybytearray.length);

            os.flush();
            os.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}