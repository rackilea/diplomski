public class Main {

    public static void main(String[] args) {
        NLP.init();
    }
}

class NLP {
   static StanfordCoreNLP pipeline;

   public static void init() {
        InputStream input = NLP.class.getClass().getResourceAsStream("/example.properties");
        Properties prop = new Properties();
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pipeline = new StanfordCoreNLP(prop);
    }
}