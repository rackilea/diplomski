JComboBox<Item> jc = new JComboBox<Item>();
    jc.setRenderer(new ListCellRenderer<Item>() {
        @Override
        public Component getListCellRendererComponent(
                JList<? extends Item> list, Item value, int index, boolean isSelected, boolean cellHasFocus) {
            if(isSelected && list.getSelectedIndex () != index)
                return new JLabel(value.getNumber());

            return new JLabel(value.getNumber() +" "+value.getName());
        }
    });