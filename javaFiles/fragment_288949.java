public class Main {

    public static void main(String[] str) throws Exception{

        File f = new File("C:\\prince\\temp\\test.txt");
        FileInputStream fis = new FileInputStream(f);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;

        while ((line = br.readLine()) != null) {
            String[] splitedTokens = line.split("[,]");
            for (String splitedToke : splitedTokens) {
                System.out.println(splitedToke);
            }
        }


    }
}