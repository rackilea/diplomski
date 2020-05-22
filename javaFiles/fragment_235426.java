public class YourClass extends Activity
{
     int RandomIndex;   // initialize variable here

     public void onCreate(...)
     {
          ...
     }

buttonA.setOnClickListener(new View.OnClickListener() {

    public int GetRandomNumber(int max) {
        int min;
        min = 1;
        int num = min + (int) (Math.random() * ((max - min) + 1));

        return num;
    }

    public void onClick(View view) {

        int countMax = 40;
        RandomIndex = GetRandomNumber(countMax);   // set value here
   }

});