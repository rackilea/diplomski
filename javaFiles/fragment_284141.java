Flowable.just(10, 30, 40, 50, 20, 30, 50, 30, 80)
        .compose(FlowableTransformers.bufferWhile(new Predicate<Integer>() {
            private int sum = 0;

            @Override
            public boolean test(Integer next) {
                if (sum + next > 100) {
                    sum = next;
                    return false;
                } else {
                    sum += next;
                    return true;
                }
            }
        }))
        .subscribe(System.out::println);