private void launchHomeScreen() {
    Intent intent = new Intent(Intent.ACTION_MAIN);
    intent.addCategory(Intent.CATEGORY_HOME);
    startActivity(intent);
    finish(); // finish our Activity (based on your requirement)
}