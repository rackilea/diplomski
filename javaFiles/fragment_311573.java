public class WmicTest {

    public static void main(String[] args) throws IOException {

        Process proc = Runtime.getRuntime().exec("wmic.exe process where name='osk.exe' get caption");
        BufferedReader input = new BufferedReader(new InputStreamReader(proc
                .getInputStream()));
//        OutputStreamWriter oStream = new OutputStreamWriter(proc
//                .getOutputStream());
//        oStream.write("process where name='osk.exe' get caption");
//        oStream.flush();
 //       oStream.close();
        input.readLine();
        String in;
        while ((in = input.readLine()) != null) {
            if (in.contains("osk.exe")) {
                System.out.println("Found");
                input.close();
                proc.destroy();
                return;
            }
        }
        input.close();
        proc.destroy();
    }
}