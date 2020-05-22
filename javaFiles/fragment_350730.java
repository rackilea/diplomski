@Override
public void onClick(View v) {
    switch (v.getId()) {
    case R.id.left:
    if(index!=0){
     index--;
     }else { 
        // this else is important because when the index=0, it must show the
       //last element of the array when swiped again..! and begin the cycle over again..!  
      index= TextList.size();
      index--;
    }
    textView.setText(TextList.get(index));
    break;

   case R.id.right:
     index++;
    if(index>=TextList.size()){
    index=0;
    }
 textView.setText(TextList.get(index));
    break;

 }}