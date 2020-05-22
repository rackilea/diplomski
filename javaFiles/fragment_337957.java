public Simplenotepad() {

this.setSize(250, 250);
this.textArea.setFont(f);
this.setTitle("A Simple Notepad");
this.textArea.setLineWrap(true);

// this.scrollPane.add(textArea); //This not correct, add Component to Viewport View
this.scrollPane.setViewportView(textArea);
setDefaultCloseOperation(EXIT_ON_CLOSE);

this.getContentPane().setLayout(new BorderLayout());
//this.getContentPane().add(textArea);
this.getContentPane().add(scrollPane, BorderLayout.CENTER);

this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
this.setVisible(true);}