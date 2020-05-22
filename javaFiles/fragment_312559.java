public class MainActivity extends Activity
{
String nama;
.....
..... 

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data){
super.onActivityResult(requestCode,resultCode, data);
if(requestCode == 22 && resultCode == RESULT_OK){
    View view = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
            .getView();
    addButton.setText(data.getStringExtra("Nama"));
    nama = (data.getStringExtra("Nama"));

.....

}