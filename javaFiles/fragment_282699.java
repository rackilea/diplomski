c.open(MainActivity.this);

public void open(Context context) {
    Intent intent = new Intent(context, SecondActivity.class);
    context.startActivity(intent);
}