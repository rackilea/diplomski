private void showQuestion(int question) {
    ql.setText(qa[question][0]);
    ql.setVisible(true);

    for (int l = 0; l < 4; l++) {
        ch[l].setVisible(true);
        ch[l].setText(String.valueOf((int) (50 * Math.random())));
    }
    int rc = (int) (4 * Math.random());
    ch[rc].setText(qa[question][1]);
}

...
// In some method...
nx.addActionListener(new ActionListener() {
    int nextQuestion = 1;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (k < 1) {
            showQuestion(nextQuestion++);
        }
    }
});
showQuestion(0); // Shows the first question