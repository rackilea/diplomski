listview.setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int arg2,
            long arg3) {
        // TODO Auto-generated method stub
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        Animation rotateAnimation = new       
        RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f); 
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(3);
        rotateAnimation.setDuration(3000);              
        imageView.startAnimation(rotateAnimation);        
    }
});