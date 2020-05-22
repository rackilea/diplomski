public Object getSlave() {
    if( "string".equals(master)) {
        return String.valueOf(slave);
    } else {
        return slave;
    }
}