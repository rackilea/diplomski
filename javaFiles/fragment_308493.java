String activityToStart = "com.example.MainActivity";
try {
    Class<?> c = Class.forName(activityToStart);
    Intent intent = new Intent(this, c);
    startActivity(intent);
} catch (ClassNotFoundException ignored) {
}