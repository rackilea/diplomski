public class SearchProviderButton extends RelativeLayout{
 .
 .
 .

 @Override
 protected void onFinishInflate() {
  super.onFinishInflate();

  //the <include> in the layout file has added these views to this 
  //so search this for the views
  ImageView logo = this.findViewById(R.id.pv_logo);
  logo.setImageResource(connector.getLogoDrawableID());


  TextView searchTV = (TextView)this.findViewById(R.id.pv_tv_search);
  TextView andTV = (TextView)this.findViewById(R.id.pv_tv_and);
  if(!connector.isSearchSupported()){
   andTV.setText("");
   searchTV.setVisibility(GONE);
  }

  setgenreIcons();
 }
 .
 .
 .