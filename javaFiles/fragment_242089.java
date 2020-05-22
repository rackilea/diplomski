@Override
public void onClick(View v) {
    SuperClass[] array = new SuperClass[] { new SuperClass(), new FirstSubClass(), new SecondSubClass(), new SuperClass() };
    SomeClass cl = new SomeClass("My Label", array);
    Intent intent = new Intent(this, NextActivity.class);
    intent.putExtra("PASS", cl);
    startActivity(intent);
}