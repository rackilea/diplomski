public Log(String a) {
    super("LOG");
    setSize(720, 600);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    p.add(txt);
    add(p);
    addTo = a;
    txt.setText(addTo);

}