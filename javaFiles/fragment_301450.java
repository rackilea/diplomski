Observable.<Long> just(1L, 2L, 3L)
        .map(new Func1<Long, Long>() {
            @Override
            public Long call(Long aLong) {
                if (aLong == 2 && errCount.getAndIncrement() < 1) {
                    throw new RuntimeException("retryable error");
                }
                return aLong * 100;
            }})
        .retry(2)
        .filter(new Func1<Long, Boolean>() {
            Set<Long> state = null;

            @Override
            public Boolean call(Long a) {
                if (state == null)
                    state = new HashSet<Long>();
                if (!state.contains(a)) {
                    state.add(a);
                    return true;
                }
                return false;
            }})
        .forEach(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                System.out.println(aLong);
            }});