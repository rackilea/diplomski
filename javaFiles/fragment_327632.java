private Button.OnClickListener myButtonOnClickListener3 = new Button.OnClickListener()
{

    @Override
    public void onClick(View arg0) 
    {

        //I need to take picture after pressing this button...What I needs to add    here??? 
        //View v1 = L1.getFocusedChild();
        L1.setDrawingCacheEnabled(true);
        Bitmap bm = L1.getDrawingCache();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bm);
        ImageView image = (ImageView) findViewById(R.id.ImageView01);
        image.setBackgroundDrawable(bitmapDrawable);
    }

};