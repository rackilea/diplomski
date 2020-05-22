private void StartServUpdateTask() {

    if(ServUpdTimer != null)
    {
        ServUpdTimer.cancel();
    }
    ServUpdTimer = new Timer();

    ...
}