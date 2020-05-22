public static boolean isEnqueued(ThreadPoolExecutor e, Long id) {
    for(Object o: e.getQueue().toArray()) {
        if(o instanceof MyFutureTask && Objects.equals(((MyFutureTask)o).getOrderId(), id))
            return true;
    }
    return false;
}