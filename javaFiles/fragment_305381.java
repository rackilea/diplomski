class StreamConnectionPool {
    List<StreamConnection> freeConnections = openSomeConnectionsSomehow();
    StreamConnection borrowConnection(){ 
        if (freeConnections.isEmpty()) throw new IllegalStateException("No free connections");
        return freeConnections.remove(0); 
    }
    void returnConnection(StreamConnection conn){
        freeConnections.add(conn);
    }
}