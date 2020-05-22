if(view == null){

## don't make any view GONE here

}else{

}
## Play with visibility or GONE for every view here.This will solve your problem

holder.option_label_y_tt3.setVisibility(View.GONE);
holder.option_label_y_tt2.setVisibility(View.GONE);
holder.option_label_y_tt1.setVisibility(View.GONE); and more...

Then rest of your code