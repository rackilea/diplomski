private void decideToNext() {
    String device = getString(R.string.device);
    if ("normal".equalsIgnoreCase(device)) {
        Intent intent = new Intent(this, DetailedActivity.class);
        startActivity(intent);
    } else if ("large".equalsIgnoreCase(device)) {
        DetailedFragment fragment = DetailedFragment.newInstance();
        fragment.show(getSupportFragmentManager(), "Tablet_specific");
    }
}