jb.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                if (jInternalFrame.getLayer() == JDesktopPane.FRAME_CONTENT_LAYER) {
                    jdp.remove(jInternalFrame);
                    jdp.add(jInternalFrame, JDesktopPane.DEFAULT_LAYER);
                    jdp.revalidate();
                    jdp.repaint();
                }
                jInternalFrame.pack();
                jInternalFrame.setIcon(true);
            } catch (PropertyVetoException ex) {
            }

        }
    });