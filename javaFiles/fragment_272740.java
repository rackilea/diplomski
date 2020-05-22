public class HelloAndroid extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 6; i++)
                {
                    TableLayout tl = (TableLayout) findViewById(R.id.T);
                    TableRow tr = (TableRow) tl.getChildAt(i);
                    for (int j = 0; j < 6; j++)
                    {
                        ImageView img = (ImageView) tr.getChildAt(j);
                        Random randomGenerator = new Random();
                        int randomInt = randomGenerator.nextInt(2);
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                if (randomInt == 1)
                                {
                                    img.setImageResource(R.drawable.w);
                                }
                                else
                                {
                                    img.setImageResource(R.drawable.b);
                                }
                            }
                        });
                        try
                        {
                            Thread.sleep(100);
                        }
                        catch (InterruptedException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }
}