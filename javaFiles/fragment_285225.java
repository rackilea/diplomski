public class Actionbar_BtnHandler extends Activity {
    Context context;
    public  Actionbar_BtnHandler (Context context)
    {
        this.context=context;
    }
    public void btn_handler (Button btn_mic,Button btn_post)
    {
        btn_mic.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context,"MIKE",Toast.LENGTH_LONG).show();
            }
        });

        btn_post.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

            }
        });
    }