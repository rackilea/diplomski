@Override
public void keyPressed(KeyEvent evt) {
         if (evt.getKeyCode()==KeyEvent.VK_CONTROL) { ctrl  = true; }
    else if (evt.getKeyCode()==KeyEvent.VK_SHIFT)   { shift = true; }
    else if (evt.getKeyCode()==KeyEvent.VK_ALT)     { alt   = true; }
    else {
        keyHit = KeyEvent.getKeyText( evt.getKeyCode() );
        System.out.println("Key Hit is "+keyHit);
    }

    processLocalKeyEvent(evt);
}

@Override
public void keyReleased(KeyEvent evt) {

    if (evt.isControlDown() && keyHit != "") ctrl  = true;
    if (evt.isAltDown()     && keyHit != "") alt   = true;
    if (evt.isShiftDown()   && keyHit != "") shift = true;

    if (ctrl)  sb.append("Ctrl");
    if (shift) sb.append("Shift");   
    if (alt)   sb.append("Alt"); 
    if (!ctrl && !shift && !alt) {
        sb.append(keyHit);
    } else {
        sb.append("_"+keyHit);
    }

    if (ctrl || shift || alt) {
        Thread thread = new Thread();
        try {
            thread.sleep(300);
            rfbProto.capture();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } else if ((ctrl || shift || alt) && keyHit=="") {
        rfbProto.capture();
    } else if ((!ctrl || !shift || !alt) && keyHit!="") {
        rfbProto.capture();
    }

    ctrl  = false;
    shift = false;
    alt   = false;
    keyHit = "";
    sb = new StringBuffer();
    processLocalKeyEvent(evt);
}