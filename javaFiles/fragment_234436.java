ArrayList<Button> buttons = new ArrayList<Button>();
//Fill list to your heart's content

Collections.shuffle(numbers);
for(int i = 0; i < buttons.length() && i < numbers.length(); i++) {
    buttons.get(i).setText(numbers.get(i).toString());
}