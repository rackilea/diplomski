for (Object1 ob : items) {
    synchronized (ob) {
        ob.setId(item.getFloorId());
        ob.setPath(item.getPath());
        ob.setTypeName(item.getTypeName());
    }
}