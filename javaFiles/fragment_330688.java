public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final TextView tv = (TextView)findViewById(dreamText);
    final Button button = (Button) findViewById(R.id.recordDream);
    File path = this.getFilesDir();
    File file = new File(path, "dreamWritings.txt");
    FileOutputStream stream;
    button.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            String dreamWords = tv.getText().toString();

      try {
                stream = new FileOutputStream(file, true);
            }
        catch(FileNotFoundException ex2){
                System.out.println(ex2);
            }
        try {
            stream.write(dreamWords.getBytes());
            tv.setText("Hey I think we wrote that to a file!");
        }
        catch(IOException ex) {
            System.out.println(ex);
        }finally{ 
           stream.close();
        }
        tv.setText("Your dream has been recorded");
    }
});

}