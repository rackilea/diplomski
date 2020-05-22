if(Name == true)
    {
        g.setColor(Color.BLACK);
        g.drawString(display, textx, texty);
        Name = false;
    }
    else if(Name == false)
    {
        g.drawString(none, textx, texty);
        Name = true;
    }