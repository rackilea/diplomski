private class AwesomePagerAdapter extends PagerAdapter {
    private String[] titles = new String[]{"Page 1 title", "Page 2 title"};

    .
    .

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position % titles.length];
    }
}