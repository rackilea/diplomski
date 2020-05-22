MouseListener mListener = new MouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel9MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabel9MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabel9MouseExited(evt);
        }
    });



jLabel9.addMouseListener(mListener);
jLabel9.removeMouseListener(mListener);