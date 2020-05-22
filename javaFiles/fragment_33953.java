yourButton.addActionListener(New ActionListener() {
        public void actionPerformed(ActionEvent e2) {

                if(index<line.length){
                        rowHeader.gotoStartOfLine(codeDrowing, line[index]);
                        index++;
                }else{
                        index = 0;
                }
        }
});