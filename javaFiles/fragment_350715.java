public class DownloadTest {

public static void main(String[] args) {

    Thread thread = new Thread(){
        @Override
        public void run() {
            // TODO Auto-generated method stub
            super.run();
            try {
                dowanloadFile(new URL("some url"), new File("some file"));
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    };
    thread.start();


   }

private static void dowanloadFile(URL url, File file){
    try {
        FileUtils.copyURLToFile(url, file );
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}