public static String readLogFile () {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("/var/log/tomcat8/catalina.out"))) {          
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {           
            // exception handling
        }
        return sb.toString();
    }