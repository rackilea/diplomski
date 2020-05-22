if (e.getSource() == b2) {
    String[] token = text.getText().split("[\\n\\s]+");
    for (String s : token) {
        System.out.println(s);
    }
}