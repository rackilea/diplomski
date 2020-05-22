private static final ThreadLocal<Map<Date, Boolean>> dateBooleantl = ThreadLocal.withInitial(() -> {
        Map<Date, Boolean> map = new HashMap<>();
        map.put(new Date(), true);
        //do other stuff...
        return map;
    });