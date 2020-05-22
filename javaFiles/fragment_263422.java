@Override
protected Void doInBackground() throws Exception {
     while(true)
    {
        System.out.println("Runing" + this.index);
        move();
        if(this.x < 40) this.x = 40;
        if(this.x > PlayField.width - 40) this.x = (PlayField.width - 40);
        if(this.y < 40) this.y = 40;
        if(this.y > PlayField.height - 40) this.y = (PlayField.height - 40);
         try {
             Thread.sleep(200);
         } catch (InterruptedException ex) {
             Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}