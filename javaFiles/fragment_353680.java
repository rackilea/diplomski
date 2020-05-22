WindowAdapter adapter = new WindowAdapter(){
    void windowClosed(WindowEvent e){
        //open next window.
    }
}

jFrame.addWindowListener(adapter);