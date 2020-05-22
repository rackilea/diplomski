v.findViewById(R.id.maketransferReviewButton).setOnClickListener(
                                                new View.OnClickListener() { 
@Override public void onClick(View v) { 
  SampleDialog fragment = new examplefile(); 
  Bundle args = new Bundle();
  args.putString("spinnerText", spinner1.getSelectedItem().toString());
  fragment.setArguments(args);
  examplefile.show(getFragmentManager(), "make a transfer dialog"); 
 } 

});