public void actionPerformed(ActionEvent e) {  
    Object fuente = e.getSource();
    if(fuente == jButton1){
        b1apretado();                     
    }
    if(fuente == jButton2){   
        b2apretado();                     
    } 
    Thread thread=new Thread(this);
    thread.start();                  
}