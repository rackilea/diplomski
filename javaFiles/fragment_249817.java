@Override
        public Fragment getItem(int position) {
            switch (position) {
            case 0:
                return new DetailFragment();
            case 1:
                return new ImageFragment(R.drawable.ic_launcher);
            case 2:
                return new ImageFragment(R.drawable.thumb);

            default:
                return null;
            }
        }