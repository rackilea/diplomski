public static void main(String[] args) {       
   try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {                               
            for (String nextLine, line = br.readLine(); line != null && !line.equals("done"); line = nextLine) {                
                nextLine = br.readLine();
                // Work with "line"
            }
   }
   catch (IOException ex) {         
        System.exit(-1);
   }
}