for(int i=0; i<checkBoxes.size(); i++) {
    final int finalI = i;

    checkBoxes.get(i).addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent arg0){
            someMethod(finalI);
        }
    });
}