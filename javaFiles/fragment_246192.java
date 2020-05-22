frame = new JFrame();
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("QuizIT | Knowledge is Power...");
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        frame.setContentPane(new Paneel());
        frame.pack();   // NOTE HERE!