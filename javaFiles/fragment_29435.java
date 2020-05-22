@Override
public void onBackPressed() {
    if (viewPager.getCurrentItem() != 0) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    } else super.onBackPressed();
}