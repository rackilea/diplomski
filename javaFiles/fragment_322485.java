public void onClick(View arg0) {
String a=null;
switch(arg0.getId()){
case R.id.left:


    if( count==0)
        prev.setEnabled(false);
    else{
         count--;
         //You want to change the text(count) of button1,2,3,4,5 when you click prev.
         //So, do that here

bb1.setText("" + count);
bb2.setText("" + count);
bb3.setText("" + count);
bb4.setText("" + count);
bb5.setText("" + count);

         //Similarly on next clicked

    break;
case R.id.right:
    if( count>5)
        next.setEnabled(false);
    else{
         count++;
bb1.setText("" + count);
bb2.setText("" + count);
bb3.setText("" + count);
bb4.setText("" + count);
bb5.setText("" + count);

    break;
case R.id.b1:
        //here don't change any text, just check the text value and call the respective answer
       if(bb1.getText == "5"){
          //call answer5 etc..,
          }

          //do the same with other buttons b2,3,4,5
    break;
case R.id.b2:

        a= (( count*0)+1)+"";
        bb2.setText(a);

    break;
case R.id.b3:

        a= (( count*0)+2)+"";
        bb3.setText(a);

    break;
case R.id.b4:

        a= ((count*0)+3)+"";
        bb4.setText(a);

    break;
case R.id.b5:

        a= ((count*0)+4)+"";
        bb5.setText(a);

    break;

}