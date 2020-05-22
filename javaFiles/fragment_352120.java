actionPerformed(){
    new Thread(){
        public void run(){
            file = fileChooser.getSelectedFile();
            doStuffWithFile(file);
        }
     }.start()
}