public class HelloWorld extends Thread {
public void run() {
    int i=1;
    String resultText;
        try {
            URL url;
            if (args.length > 0) {
                url = new File(args[0]).toURI().toURL();
            }
            else {
                url = HelloWorld.class.getResource("helloworld.config.xml");
            }