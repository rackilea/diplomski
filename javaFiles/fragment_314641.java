for(int i = 0; i < switchstate.length; i++) {
    final int j = i;
    switches[i].addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e)
        {
            if(switchstate[j])
            {
                if(ON_RECTANGLE.contains(e.getX(), e.getY()))
                    switchstate[j] = false;
            }
            else
            {
                if(OFF_RECTANGLE.contains(e.getX(), e.getY()))
                    switchstate[j] = true;
            }

            paintStuff();
        }
    });
}