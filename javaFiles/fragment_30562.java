public class B extends Activity
{
   public static int RESULT_CODE=111;

   public void onCreate(Bundle SavedInstance)
   {
   ...
   ....
   Intent intent = new Intent(B.this,C.class);
   startActivityForResult(intent,REQUEST_CODE);
   }


   public void onActivityResult(int requestCode,int resultCode,Intent data)
   super.onActivityResult(requestCode, resultCode, data);
   if(requestcode == C.RESULT_OK)
       {

       //do you work when D is finished and comes back to B
        }

    }


public class C extends Activity
{
     public static int RESULT_CODE=222;

     public void onCreate(Bundle SavedInstance)
     {
     ...
     ....
     Intent intent = new Intent(C.this,D.class);
     startActivityForResult(intent,REQUEST_CODE);
     }


    public void onActivityResult(int requestCode,int resultCode,Intent data)
    super.onActivityResult(requestCode, resultCode, data);
    if(requestcode == D.RESULT_OK)
    {
    setResult(RESULT_OK);
    }

   } 


    public class D extends Activity
    {
      public static int RESULT_CODE=333;

      public void onCreate(Bundle SavedInstance)
      {
      ...
      ....

      }


      //your back click function

      public void onBackClick(View v)
      {
      setResult(RESULT_OK);
   }