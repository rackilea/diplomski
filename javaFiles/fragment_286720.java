public class PingClass {

    public void pingIt(){

        InetAddress addr;
        try {
            String line;

            Process p = Runtime.getRuntime().exec(
                    "C:/windows/system32/ping.exe 192.168.2.2");

            /**
             * Create a buffered reader from the Process' input stream.
             */
            BufferedReader input = new BufferedReader(new InputStreamReader(p
                    .getInputStream()));

            /**
             * Loop through the input stream to print the program output into console.
             */
            ArrayList<String> str = new ArrayList<String>();
            while ((line = input.readLine()) != null) {
                str.add(line);
                System.out.println(line);

            }
            /**
             * Finally close the reader
             */
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   


    public static void main(String[] args){


        new PingClass().pingIt();
    }

}