PanZoom.attach(plot).setDelegate(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {

             case MotionEvent.ACTION_DOWN: {
                 //Update graph labels with plot.getBounds().asRectF();
                 rangeLabel1.setText("My TextView rangeLabel gets updated here!");
                 rangeLabel2.setText("You have to calculate value for each label")
                 domainLabel1.setText("Do the same for domain labels also");
                 domainLabel2.setText("etc...");
                 break;
             }

             case MotionEvent.ACTION_MOVE: {
                 //Update graph labels with plot.getBounds().asRectF();
                 rangeLabel1.setText("My TextView rangeLabel gets updated here!");
                 rangeLabel2.setText("You have to calculate value for each label")
                 domainLabel1.setText("Do the same for domain labels also");
                 domainLabel2.setText("etc...");
                 break;
             }

             case MotionEvent.ACTION_UP: {
                  //Update graph labels with plot.getBounds().asRectF();
                  rangeLabel1.setText("My TextView rangeLabel gets updated here!");
                  rangeLabel2.setText("You have to calculate value for each label")
                  domainLabel1.setText("Do the same for domain labels also");
                  domainLabel2.setText("etc...");
                  break;
             }
       }
       //Return false to allow PanZoom to receive control
       return false;
    }
});