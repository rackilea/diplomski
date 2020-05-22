public MyTest()
{


    String alongString = "Accusata consulatu vix ad, eruditi albucius liberavisse est no. Platonem reprehendunt qui ea. Dicta recteque referrentur an his, id facete maiorum vulputate vim. At suas oratio mnesarchum quo. Quidam omnium necessitatibus ex sea, vix soleat quaerendum conclusionemque ut, case malorum nam an.No quis suas discere nam, nam ex nostro fastidii vivendum. Sed cu nobis ullamcorper. Has at doctus ponderum honestatis. In facer dicam corpora vis.";
    JTextArea myText = new JTextArea(alongString,10,100 );

    myText.setLineWrap(true);
    myText.setWrapStyleWord(true);

    JPanel simplePanel = new JPanel(new BorderLayout(5, 5));
    simplePanel.add(myText, BorderLayout.CENTER);

    this.add(simplePanel);
    this.validate();
    this.setSize(800, 600);
    this.setVisible(true);

}

public static final void main(String ... args) {
    new MyTest();
}