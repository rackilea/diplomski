final int number = 30;
final Button[] buttons = new Button[number];
final Resources resources = getResources();

for (int i = 0; i < number; i++) {
    final String name = "btn" + (i + 1);
    final int id = resources.getIdentifier(name, "id", getPackageName());

    buttons[i] = (Button) findViewById(id);
}