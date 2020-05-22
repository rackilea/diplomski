public class Main {

    public static HashMap<String, String> map = new HashMap<String, String>();
    private static String weightLimit = "";

    public static void main(String[] args){

        try {
            File file = new File("test.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            boolean first = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (first) {
                    weightLimit = line;
                    first = false;
                } else {
                    String[] values = line.split(" ");
                    map.put(values[0], values[1]);
                }

            }
            fileReader.close();
        }       catch (IOException e) {
            e.printStackTrace();
        }
        weightLimit();
    }

    public static void weightLimit() {
        System.out.println(weightLimit);
    }
}