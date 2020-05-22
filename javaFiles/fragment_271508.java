yourComposite.addListener(SWT.dispose, new Listener(){

    public void handleEvent(Event e){
            image.dispose(); 
            font.dipose();  
            color.dipose()

    }

});