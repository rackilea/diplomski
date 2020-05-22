req.getSession(false).invalidate();
    req.getSession(true);
    resp.sendRedirect("check_restart_status.jsp");
    //Use a timer or whatever
    new Thread(() -> {
        try{
          Thread.sleep(5000);
        } catch(InterruptedException ie) {
          return;
        }
        restartWebApp("/salsadb");
    }).start();