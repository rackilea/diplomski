myCombo.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                String a=jcombobox.getselecteditem().toString();
                System.out.print(a); 
            }
        }
    });