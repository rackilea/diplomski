myComboBox.setRenderer( new DefaultListCellRenderer(){

        @Override  
        public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
                if(value == null){
                     return this;    
                }

                if(value instanceof File){
                  File song = (File)value;
                  setText(song.getName());
                }else{
                  setText(value.toString());
                }
            return this;
        }
});