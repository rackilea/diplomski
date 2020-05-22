...
final Random random = new Random();
...
@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    bt1 = (ImageButton) findViewById(R.id.im_bt1);
    bt1.setImageDrawable(randomFromArray(images[index]));

    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (++index == 4) {
                // reset index if it is too high after increment
                index = 0;
            }
            ((ImageButton) v).setImageDrawable(randomFromArray(images[index]));
}

public <T> T randomFromArray(final T[] array) {
    return array[random.nextInt(array.length)];
}