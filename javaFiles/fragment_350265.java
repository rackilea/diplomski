jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

ArrayList<Color> colors = new ArrayList<>();

colors.add(Color.RED);
colors.add(Color.BLUE);
colors.add(Color.GREEN);
colors.add(Color.YELLOW);

String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

ArrayList<Character> letters = new ArrayList<>(); {

for (char c : alphabet.toCharArray()) {
      letters.add(c);
    }

char randomLetter = letters.get(rnd.nextInt(letters.size()));

ArrayList<JButton> buttons = new ArrayList<>();

for (int i = 0; i < 16; i++){
    JButton jb = new JButton();
    buttons.add(jb);
    jp.add(jb);
}

JButton randomJButton = buttons.get(rnd.nextInt(buttons.size()));

for (JButton button : buttons){
    Color randomColor = colors.get(rnd.nextInt(colors.size())); // Get a new random color
    button.setBackground(randomColor);
    button.setOpaque(true);
}