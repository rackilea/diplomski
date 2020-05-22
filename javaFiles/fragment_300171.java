public class HelloWorld {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(HelloWorld.class.getClassLoader().getResourceAsStream("test.txt")))) {
          String line;
          while ((line = br.readLine()) != null) {
              System.out.println(line);
          }
       }
    }
}