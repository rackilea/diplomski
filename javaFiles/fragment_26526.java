@Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return newInstance("1");
            case 1:
                return newInstance("2");
            case 2:
                return newInstance("3");
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "1";
            case 1:
                return "2";
            case 2:
                return "3";
            default:
                return "";
        }
    }

  public OneFragment newInstance(String param1) {
    OneFragment fragment = new OneFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    fragment.setArguments(args);
    return fragment;
}