public class Test extends MainActivity implements MainActivity.MyInterfcae
{
    Context context;

    @Override
    public void test0(final Context context)
    {
        this.context = context;

        Button b = (Button) ((Activity)context).findViewById(R.id.button0);

        b.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0) {

                Toast toast = Toast.makeText(context, "Implemented!", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


    }
}