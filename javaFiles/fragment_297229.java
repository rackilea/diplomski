void run()
{
    // do stuff
    .
    .
    .
     activity.runOnUiThread(new Runnable()

         void run()
         {
             spinner1.setAdapter(adapter);
         }

     );
}