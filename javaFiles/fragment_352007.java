public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String imageFilename = "pippo.png";
        //example username, I am not sure how you get this info
        String exampleUsername = "user1";   

        try {
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
            //check that we are good here...
            if(directory.exists())
                Log.d("ImageTAG", "'imageDir' exists");

            // create imageDir
            File completeImagePath = new File(directory, imageFilename);

            //write file
            FileOutputStream out = new FileOutputStream(completeImagePath);

            out.flush();
            out.close();

            //check to ensure complete image path exists... it should
            if(completeImagePath.exists())
                Log.d("ImageTAG", "'completeImagePath' exists");

            //show full path on device
            Log.d("ImageTAG", "Image saved success, complete Image Path: " +
                    completeImagePath.getAbsolutePath());

            //redeclaration of file here is not needed, but added for clarity
            File from = new File(completeImagePath.getAbsolutePath());
            //what you are renaming the file to
            File to = new File(directory, exampleUsername + ".png");
            //now rename
            Boolean success = from.renameTo(to);

            Log.d("ImageTAG", "Successful Rename: "+success.toString()+"| File is now named: "+to.getPath());

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("ImageTAG","saved failed");
        }

    }
}