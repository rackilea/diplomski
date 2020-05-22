SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            JFrame frame = new JFrame("FrameDemo");
            frame.setMinimumSize(new Dimension(800, 400));

            JButton button = new JButton("Cliccami");
            MyButtonListener listener = new MyButtonListener();

            button.addActionListener(listener);
        }
    });