if(OUTPUT_IN_OVERLAY_CONSOLE || OUTPUT_IN_FILE || !OUTPUT_IN_CONSOLE) {
        try {
            JFrame console = new JFrame("Console");
            console.setSize(720,320);
            final JTextArea tarea = new JTextArea();
            JScrollPane scroll = new JScrollPane(tarea);
            console.add(scroll);                

            final OutputStream consoleOut = System.out;
            final OutputStream fileOut  = new FileOutputStream("output.txt");
            final OutputStream o = new OutputStream() {
                StringBuilder sb = new StringBuilder();
                @Override
                public void write(int b) throws IOException {
                    sb.append((char)b);
                    tarea.setText(sb.toString());
                    tarea.setCaretPosition(sb.length());
                    //tarea.requestFocus();
                }
            };

            OutputStream overrideOut = new OutputStream() {

                @Override
                public void write(int b) throws IOException {
                    if(OUTPUT_IN_CONSOLE) consoleOut.write(b);
                    if(OUTPUT_IN_OVERLAY_CONSOLE) o.write(b);
                    if(OUTPUT_IN_FILE)  fileOut.write(b);
                }
            };
            System.setOut(new PrintStream(overrideOut));

            if(OUTPUT_IN_OVERLAY_CONSOLE) {
                console.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                console.setVisible(true);
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }