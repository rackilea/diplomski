public static void main(String[] args) throws IOException {
        String command = new String("/tmp/1/Test.sh");   
        Runtime rt = Runtime.getRuntime();
        Process process = rt.exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(        
                process.getInputStream()));

        String s;                                                                
        while ((s = reader.readLine()) != null) {                                
            System.out.println("Script output: " + s);   
        }

        BufferedReader stdError = new BufferedReader(new 
             InputStreamReader(process.getErrorStream()));

        System.out.println("Here is the standard error\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }

    }