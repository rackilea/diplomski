int imgs[] =  
        {  
            R.drawable.mashad_one, 
            R.drawable.mashad_two, 
            R.drawable.mashad_three, 
            R.drawable.mashad_four,
            R.drawable.mashad_five,
            R.drawable.mashad_six,
            R.drawable.mashad_seven,
        };
 int i=0,flag=0;
ImageSwitcher imgBus;
AnimationDrawable animation; 
Handler mHandler = new Handler();
void func()
{
     imgBus.setFactory(this);
}


@SuppressLint("NewApi") @Override
     protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.dutyfree);
            ActionBar bar = getActionBar();
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6600")));  // Declare object of Utils class;
            Gallery gallery = (Gallery) findViewById(R.id.gallery1);
            gallery.setAdapter(new ImageAdapter(this));

            gallery.setOnItemClickListener(new OnItemClickListener() {

                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                        long arg3) {

                    if(i==0)

                    {
                        i++;
                        func();
                    }

                    flag=1;
animation.stop();
                    imgBus.setImageResource(imgs[arg2]);
                }
            });

           imgBus = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
         imgBus.setBackgroundResource(R.drawable.anim);

                imgBus.setInAnimation(AnimationUtils.loadAnimation(this,
                        android.R.anim.fade_in));
                imgBus.setOutAnimation(AnimationUtils.loadAnimation(this,
                        android.R.anim.fade_out));

            animation = (AnimationDrawable) imgBus.getBackground();


            animation.start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    while (true) {
                        try {
                            Thread.sleep(5000);
                            mHandler.post(new Runnable() {

                                @Override
                                public void run() {
                                    // TODO Auto-generated method stub


                         // Write your code here to update the UI.
                                        if(flag==1){
    imgBus.reset();
                                            animation.start();
                                        }
                                    }
                                });
                            } catch (Exception e) {
                                // TODO: handle exception
                            }
                        }
                    }
                }).start();


    }

    public class ImageAdapter extends BaseAdapter {
        private Context ctx;

        public ImageAdapter(Context c) {
            ctx = c; 
        }

        public int getCount() {

            return imgs.length;
        }


        public long getItemId(int arg0) {

            return arg0;
        }

        public View getView(int arg0, View arg1, ViewGroup arg2) {

            ImageView iView = new ImageView(ctx);
            iView.setImageResource(imgs[arg0]);
            iView.setScaleType(ImageView.ScaleType.FIT_XY);
            iView.setLayoutParams(new Gallery.LayoutParams(200, 150));
            return iView;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }
    }

    public View makeView() {
        ImageView iView = new ImageView(this);
        iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iView.setLayoutParams(new ImageSwitcher.LayoutParams
            (LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        iView.setBackgroundColor(0xFF000000);
        return iView;
    }

}