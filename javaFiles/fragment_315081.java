if(name == true)
    //if(name) // even simpler, you don't need the "== true"
    {
        g.setColor(Color.BLACK);
        g.drawString(display, textx, texty);
    }
    else 
    {
        g.drawString(none, textx, texty);
    }