public static class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Fragment getItem(int position) {
        return getFragmentBasedOnPosition(position);
    }

    private Fragment getFragmentBasedOnPosition(int position) {
        int fragmentPos = position % 3; // Assuming you have 3 fragments
        switch(fragmentPos) {
            case 1:
            return Fragment1.newInstance();
            case 2:
            return Fragment2.newInstance();
            case 3:
            return Fragment3.newInstance();
        }
    }
}