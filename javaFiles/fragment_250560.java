public OnItemClickListener listener = new OnItemClickListener() {
    int i = 1;
    int p;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id){
        loaddetails(pf, position);
        i++;
        p=position;
        if(lastID == id || lastID == -1){
            details.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter));
            details.setVisibility(View.VISIBLE);
        }else{
            details.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade2));
            details.setVisibility(View.GONE);
        }
        lastID = id;
    }
};