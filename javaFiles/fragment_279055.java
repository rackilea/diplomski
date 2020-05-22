final Invite invite = (Invite) criteria.uniqueResult();
...
Timer timer = new Timer();
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        invite.setExpired(true);
    }
}, MAX_TIME);