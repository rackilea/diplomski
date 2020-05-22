public enum Colors {
    GREEN, RED, YELLOW;
}

...

List<Colors> list = new ArrayList<Colors>(Arrays.asList(Colors.values()));
Random rand = new Random();

...

public void button(View view) {
    if (list.isEmpty()) {
        textView.setText("Empty");
    } else {
        Colors randomElement = list.remove(rand.nextInt(list.size()));
        textView.setText(randomElement.name());
    }
}