public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateFrame frameFromMain = new CreateFrame("Label1");
                CreateFrame.label.setText("new Label"); // accessing label directly from main()

            }
        });
    }