public void paint(Graphics g)
{
    d = getSize();
    for(int m=0;m<=50;m++){
        g.clearRect(0, 0, (int) d.getWidth(), (int) d.getHeight());

        int k = Math.abs((r.nextInt()) % 6) + 1;
        g.setFont(f);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(k) , 70, 100);
        try{Thread.currentThread().sleep(70);}(Exception e){}
    }
}