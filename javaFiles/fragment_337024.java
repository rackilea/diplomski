Iterator<Meteor> iter = getMeteorArrayList().iterator();
    while (iter.hasNext ()) {
        Meteor m = iter.next ();
        if (m.getVisible()) {
            canvas.drawBitmap(m.getImg(), m.getX(), m.getY(), p);
        } else {
            iter.remove();
        }
    }