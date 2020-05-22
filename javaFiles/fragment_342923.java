EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

                // Set Motif L&F on any platform
                // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

                // Set cross-platform Java L&F (also called "Metal")
                // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

                // Set System L&F
                //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            } catch (UnsupportedLookAndFeelException ex) {
            }

            Object[] options = { "Encrypt", "Decrypt" };

            JOptionPane.showOptionDialog(new JFrame(), "What Do You Want to Do?", "Crypto",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a
                                                                                   // custom Icon
                    options, // the titles of buttons
                    options[0]); // default button title
        }
    });