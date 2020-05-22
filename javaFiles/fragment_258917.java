@Override
public void onClick(View v) {
    //your code
    switch  (v.getId()) {
        case R.id.random_button:
            current = new Random().nextInt(sayings.length);
            String randomSaying = (sayings[current]);
            sayingsTextView.setText('"' + randomSaying + '"');
            resId = sayingsResIds.get(randomSaying);
            sayingsTextView.startAnimation(anim);
            if(current == 0){
                btnBack.setEnabled(false);
                btnNext.setEnabled(true);
            } else if(current == sayings.length - 1){
                btnBack.setEnabled(true);
                btnNext.setEnabled(false);
            } else {
                btnBack.setEnabled(true);
                btnNext.setEnabled(true);
            }
            break;

        case R.id.next_button:  
            // Click Next to find next saying in the array
            if(current == 0){
                btnBack.setEnabled(true);
            }
            current++;
            String randomSaying = (sayings[current]);
            sayingsTextView.setText('"' + randomSaying + '"');
            resId = sayingsResIds.get(randomSaying);
            sayingsTextView.startAnimation(anim);  
            if(current == sayings.length - 1){
                btnNext.setEnabled(false);
            }     
            break;

        case R.id.back_button:
            // Click Next to find next saying in the array
            if(current == sayings.length - 1){
                 btnNext.setEnabled(true);
            }
            current--;
            String randomSaying = (sayings[current]);
            sayingsTextView.setText('"' + randomSaying + '"');
            resId = sayingsResIds.get(randomSaying);
            sayingsTextView.startAnimation(anim);  
            if(current == 0){
                btnBack.setEnabled(false);
            }     
            break;
    }
    // your code
}