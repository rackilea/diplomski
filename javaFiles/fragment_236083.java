fav_up_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        boolean favIsUp = fav_up_btn.getBackground().getConstantState()
                                    .equals(getResources().getDrawable(R.drawable.fav_up_btn).getConstantState());  
        //set the background                            
        fav_up_btn.setBackgroundResource(favIsUp ? R.drawable.fav_dwn_btn : R.drawable.fav_up_btn);
    }
});