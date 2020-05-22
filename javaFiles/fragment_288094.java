Runnable r = new Runnable() {
    @Override
    public void run() {
        ivList.get(1).setImageResource(R.drawable.drawable2);
    }
};
ivList.get(0).setImageResource(R.drawable.drawable1);
// no synchronized is needed
new Handler().postDelayed(r,500); // call to change the image after 500s