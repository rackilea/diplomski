//Variables
JTextField tfIn;
JLabel lblOut;
private final PipedInputStream inPipe = new PipedInputStream();
private final PipedInputStream outPipe = new PipedInputStream();
PrintWriter inWriter;

String input = null;
Scanner inputReader = new Scanner(System.in);
//Variables

    System.setIn(inPipe); 
    try {
        System.setOut(new PrintStream(new PipedOutputStream(outPipe), true)); 
        inWriter = new PrintWriter(new PipedOutputStream(inPipe), true); 
    }
    catch(IOException e) {
        System.out.println("Error: " + e);
        return;
    }
    tfIn = new JTextField();
    tfIn.addActionListener(this);
    frame.add(tfIn, BorderLayout.SOUTH);