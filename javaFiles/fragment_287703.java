//Global instance
ClickListener listenerLeft;

//show() method
...
listenerLeft= new ClickListener();  
btnLeft.addListener(listenerLeft);
...

//render() method
...
if(listenerLeft.isPressed())
    //perform turning left
...