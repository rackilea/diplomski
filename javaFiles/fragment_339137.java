import java.net.ServerSocket; 
..... 
private static final int PORT = 9999;
private static ServerSocket socket;  
public static void main(String[] args) {

    try {
        socket = new ServerSocket(PORT, 0, InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 }));

                {/*here write your own code taht must be run in the main*/}

    } catch (BindException e) {
        System.err.println("**********************************Already running.");
        System.exit(1);
    } catch (IOException e) {
        System.err.println("************************************Unexpected error.");
        e.printStackTrace();
        System.exit(2);
    } catch (Exception e) {
        System.err.println("************************************ Error");
        System.exit(3);
    }
}