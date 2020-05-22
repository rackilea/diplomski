public PostStatePagerAdapter extends FragmentStatePagerAdapter {
    private List data = null;

    public PostStatePagerAdapter(FragmentManager fm, List data){
        super(fm);
        this.data = data;

    }

@Override
public Fragment getItem(int arg0) {
        fragmentdata = data.get(arg0)

       // create your new fragment that displays your music blog entry by using fragment data got from data list
       return <your fragment>;
    }


    @Override
public int getCount() {
    return data.size();
}
}