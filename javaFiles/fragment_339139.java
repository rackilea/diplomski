Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        Platform.runLater(() -> { //Lambda for Runnable
            for (Spool s : spools){
                if (s.angle != 0){
                    if (Math.abs(s.distToAngle(0)) < Math.toRadians(1)){
                        System.out.println("snap");
                        s.snapToAngle(0);
                        for (Spool.Cell c : s.cells){
                            c.draw(s.angle);
                        }
                    }
                    else {
                        s.rotate(s.directionToAngle(0));
                        System.out.println((s.x+150)/75+1 + ": "
                            + Math.round((s.angle/Math.PI)*180));
                        for (Spool.Cell c : s.cells){
                            c.draw(s.angle);
                        }
                    }
                }
            }
        });
    }
}, 0, 10);