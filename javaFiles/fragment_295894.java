public YourClassPanel() {
// to set Look&Feel    
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            SwingUtilities.updateComponentTreeUI(this);
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    ControlPanel.tgp = null;
                }
            });

            this.setBounds(0, 0, 710, 580);
            this.setTitle("Buffer Allocation Panel");
            this.setPreferredSize(null);
            this.setResizable(false);

    this.setBackground(Color.yellow); //to set Background
    this.setForeground(Color.magenta); // to set Foreground
    this.setOpaque(a!=255); // to set Opaque

        }