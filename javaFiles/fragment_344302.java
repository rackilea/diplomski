final String[] lines;
for(int i=0; i<10; i++){
    Timer t = new Timer(500*i,new ActionListener(){
        int ind=i;
        void actionPerformed(ActionEvent e){
            area.setText(area.getText() + "\n ..."); 
        }
    });
    t.start();
}