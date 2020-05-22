final Random numtofind = new Random();
final int numtofindValue = numtofind.nextInt(51);
final TextView textNumberToHit = (TextView) findViewById(R.id.numbertofind);
    textNumberToHit.setText(String.valueOf(numtofindValue));

final Random num = new Random();
final Random textViewToSet = new Random();

// reason i am adding 1 is because nextInt(int num) returns a random number from 0 up to but not including the value of the param "num" 
// http://docs.oracle.com/javase/6/docs/api/java/util/Random.html#nextInt(int)
// and since you have 12 textviews and we want to get one of those we need to add one so the range of random numbers will be 1-12 instead of 0-11.
int textViewToSetValue = textViewToSet.nextInt(12) + 1; // which textview to set the value of numtofind

// populate hashmap with textviews
Map<Integer, TextView> textViews = new HashMap<>();

// not an efficient way of doing this - but since you are not using a GridView its the only way
textViews.put(1, textGenerateNumber1);
textViews.put(2, textGenerateNumber2);
textViews.put(3, textGenerateNumber3);
textViews.put(4, textGenerateNumber4);
textViews.put(5, textGenerateNumber5);
textViews.put(6, textGenerateNumber6);
textViews.put(7, textGenerateNumber7);
textViews.put(8, textGenerateNumber8);
textViews.put(9, textGenerateNumber9);
textViews.put(10, textGenerateNumber10);
textViews.put(11, textGenerateNumber11);
textViews.put(12, textGenerateNumber12);

TextView tvToSet = textViews.get(textViewToSetValue); // this will get the textview for a number 1 - 12

// set value of textView 
tvToSet.setText(String.valueOf(numtofindValue));

buttongenerate.setOnTouchListener(new View.OnTouchListener() {
    public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    buttongenerate.setBackgroundResource(R.drawable.pressedbut);
                    // loop through the remaining textViews and set their values to random values
                    for (Map.Entry<Integer, TextView> entry : textViews.entrySet(){
                        // make sure we dont reset the value we set earlier
                        if(entry.getKey() != textViewToSetValue){
                            entry.getValue().setText(num.nextInt(51));
                        }
                    }

                    break;
                case MotionEvent.ACTION_UP:

                    buttongenerate.setBackgroundResource(R.drawable.normalbut);
                    break;
            }
            return true;
        }
});