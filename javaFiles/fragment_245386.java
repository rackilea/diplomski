EditField edit= new EditField("", "", 100, Field.FOCUSABLE){
protected void paintBackground(Graphics g) {
           g.setBackgroundColor(Color.WHITE);
           g.clear();
       }



backg.add(edit);
add(backg);