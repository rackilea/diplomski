if(SwingUtilities.isEventDispatchThread()){
    Message.popup(...);
}
else{
    SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run(){
            Message.popup(...);
        }
    });
}