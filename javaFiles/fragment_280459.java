if(event.getNativeEvent().getType().contains("click")){
    // if you don't need this event)
    event.setCanceled(true);
    // otherwise continue
    ...
}