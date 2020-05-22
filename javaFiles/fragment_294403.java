final JComboBox box = new JComboBox(new Object[] {1, 2, 3}) {

        /** 
         * @inherited <p>
         */
        @Override
        public void setEnabled(boolean b) {
            if (b == isEnabled()) return;
            for (Component child : getComponents()) {
                if (child instanceof JButton) {
                    child.setVisible(b);
                    break;
                }
            }
            super.setEnabled(b);
        }

    };