@Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new fragment1();
            case 1:
                return new fragment2();
            case 2:
                return new fragment3();
            default:
                // this should never happen
                return null;
                //return new Fragment();
        }
    }