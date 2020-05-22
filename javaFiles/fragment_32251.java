text = "I was chosen";
JButton button1 = new Jbutton("");
JButton button2 = new Jbutton("");
JButton button3 = new Jbutton("");
List<JButton> buttons = Arrays.asList(button1, button2, button3);
Random r = new Random();
buttons.get(r.nextInt(buttons.size())).setText(text);