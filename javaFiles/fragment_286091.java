public class MainActivity extends Activity{
   //I need to read the instrument variable here
   CustomOnItemSelectedListener MyListener = new CustomOnItemSelectedListener();

   public void addListenerOnSpinnerItemSelection(){

     instrumentSp = (Spinner) findViewById(R.id.instrument);
     instrumentSp.setOnItemSelectedListener(MyListener);  
   }
}