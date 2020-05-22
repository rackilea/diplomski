void mousePressed() {

    for (int i = 0; i < l.size(); ++i) {

        if (l.get(i).isHit(mouseX, mouseY)) {
            l.get(i).setColor(color(255, 0, 0) );
        }
    } 
}