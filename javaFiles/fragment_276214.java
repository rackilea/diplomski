@Override
        public Fragment getItem(int position) {
            switch (position) {
            case 0:
                return new PrefsFragment();
            default:
                return null;
            }
        }