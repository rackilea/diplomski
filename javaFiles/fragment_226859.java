public class MyActivity extends AppCompatActivity implements ActivityCallback{
    private ArrayList<String> arrayData = new ArrayList<>();
    ...
    @Override
    void sendData(String data1, String data2){
        this.arrayData.add(data1);
        this.arrayData.add(data2);
    }
    ...

}