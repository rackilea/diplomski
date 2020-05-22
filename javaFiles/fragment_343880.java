Iterator<Connection> iterator = activeConenctions.iterator();
    while(iterator.hasNext()) {
        Connection c = iterator.next();
        if(/* what ever */) {
            iterator.remove();
        }
    }