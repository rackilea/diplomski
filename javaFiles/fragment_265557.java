jb2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                if (jInternalFrame.isMaximum()) {//restore
                    jInternalFrame.pack();
                } else {//maximize
                    jInternalFrame.setMaximum(true);
                }
                jdp.remove(jInternalFrame);
                jdp.add(jInternalFrame, JDesktopPane.FRAME_CONTENT_LAYER);
                jdp.revalidate();
                jdp.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    });