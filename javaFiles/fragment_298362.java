public void notify(User user, Event event){
    Broadcaster b = BroadcasterFactory.getDefault().lookup(user.getId());
    if (b!=null){
        b.broadcast(event);
    }
}