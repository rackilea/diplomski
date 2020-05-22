@Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case FRAGMENT_1:
                return context.getResources().getString(R.string.some_string);
        }
        return super.getPageTitle(position);
    }