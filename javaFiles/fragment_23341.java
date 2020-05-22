String[] some_array = getResources().getStringArray(R.array.your_string_array);
int index = 0 ;
...
prevButton.setOnClickListener(this);
nextButton.setOnClickListener(this);
...
@Override
public void onClick(View v) {
  switch(v.getId) {
     case R.id.your_next_button_id : 
      index++;
      break;
     case R.id.your_previous_button_id : 
      index--;
      break;
  }
  yourTextView.setText(some_array[index]);
}