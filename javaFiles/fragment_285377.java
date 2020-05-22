VivzAdapter(Context c){
    list=new ArrayList<SingleRow>();
    context = c; // add this
    Resources res=c.getResources();
    String[] polices=res.getStringArray(R.array.polices);
    String[] policenum=res.getStringArray(R.array.policenum);
    for(int i=0;i<10;i++)
    {
        list.add(new SingleRow(polices[i], policenum[i]));
    }
}