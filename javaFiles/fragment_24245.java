@Override
public void onPageSelected(int position) {
    if (position == 0) {
        search.setEnabled(false);
        search.setVisible(false);
    } else {
        search.setEnabled(true);
        search.setVisible(true);
    }
}