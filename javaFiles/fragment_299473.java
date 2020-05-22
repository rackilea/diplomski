for(int i=0 ; i<fonts.length; i++) {
    final String font = fonts[i];
    fontItemList[i] = new JMenuItem(font);  
    fontItemList[i].addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e){
            editor.setFont(new Font(font, 0, 12));
        }

    });
}