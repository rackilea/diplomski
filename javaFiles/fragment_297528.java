private ArrayMap<Integer, MyFragmentBaseClass> mPagerFragmentMap = new ArrayMap<>();


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        MyFragmentBaseClass fragment = (MyFragmentBaseClass) super.instantiateItem(container, position);
        mPagerFragmentMap.put(position, fragment);

        return fragment;
    }