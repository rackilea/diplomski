while (true) { // true or something less risky
    //for each pendingTasks call
    pool.execute(task);
    Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
    while (iter.hasNext()) {
        SelectionKey key = iter.next();
        iter.remove();
        key.cancel();
        //store dispatch for the next while iteration
        pendingTasks.add(task); // do not execute tasks before next select()
    }
    selector.select(TIMEOUT); // or selectNow if there are 
                              //any pending events to handle.
}