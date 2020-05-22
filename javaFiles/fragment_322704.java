import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    AudioAnalyzer aa = new AudioAnalyzer();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void analyzer (View view) throws FileNotFoundException{
        try {
            double[] input = readFile("/storage/sdcard/input.txt");
            double[] analyzed = readFile("/storage/sdcard/bandpass.txt");

            isWorking(aa.analyze(input, analyzed));
        catch (IOException e) {
                e.printStackTrace();
        }

    }
    private void isWorking(boolean working){
        if(working)
            textView.setText("The filter works!");
        else
            textView.setText("Try again. The filter does not work!");           
    }
    public double[] readFile(String fname) throws FileNotFoundException {


    File file = new File(fname); 
        Scanner scanner = new Scanner(new FileInputStream(file));
        List<Double> collection = new ArrayList<Double>();

        while (scanner.hasNextDouble()){
            double number = scanner.nextDouble();
            collection.add(number);
        }

        scanner.close();
        return toPrimitive(collection.toArray(new Double[collection.size()]));
    }   
    public double[] toPrimitive(Double[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return null;
        }
        final double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].doubleValue();
        }
        return result;
    }
}