float hitPercent = 0.3f; //30% of the time it will show ad
final Random generator = new Random();

myButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View view) {
        if (generator.nextFloat() <= hitPercent) {
            ad.show();
        }
    }
}