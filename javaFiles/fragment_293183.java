private Bundle extras;

public SamplerAdapter(FragmentManager fm, Bundle extras){
   super(fm);
   this.extras = extras;
}

// Now set these arguments in getItem method
    @Override
    public Fragment getItem(int position) {
        // Create your fragment set arguments in that fragment
        Fragment fragment = new LineDetails();
        fragment.setArguments(bundle);
        return fragment;
    }