synchronized(list){
    if (list.size() > 0) {
        synchronized (out) {
            out.print(list.size() + " ");
            out.flush();
        }
    }
}