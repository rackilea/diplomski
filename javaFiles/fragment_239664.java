rowView.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
         Intent intent=new Intent(v.getContext(),ActivityYouWantToGo.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         v.getContext().startActivity(intent);
         Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
    }
});