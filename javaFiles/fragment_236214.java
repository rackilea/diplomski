public Long getConnectionId() {
    try {
        //jdbc impl has getId()
        Method method = this.connection.getClass().getSuperclass().getMethod("getId");
        return (Long)method.invoke(this.connection);
    } catch (Exception e) {
        log.warn(" Abandoned QueryHandler failed to initialize connection id ");
    }
    return null;
}