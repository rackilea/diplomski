class MainActivity extends Activity {
....
....
....
....
    int counter = 0; 
    class MyAsync extends AsyncTask <void, Void, Void> {

       MyAsync()
       {
           counter++;
       }
    }

}