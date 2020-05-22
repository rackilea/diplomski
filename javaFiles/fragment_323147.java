public void activityOpener(int a) {
    Class<?> cls = a == 1
        ? proj1new.class
        : BasicNumbers.class;
    Intent intent = new Intent(this, cls);
    startActivity(intent);
}