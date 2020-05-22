public class MainActivity extends Activity{

    Button btn;

    onCreate(Bundle icreate){

        super.onCreate(icreate);
        setContentView(R.layout.main_layout);

        bnt = (Button) findViewById(R.id.buttonId);
        }

    public void anyMethod(){

        //here you can use btn without defining it again
        //suppose you are setting onClickListener then

        btn.setOnClickListener(new View...){
         ....
        }
    }

}