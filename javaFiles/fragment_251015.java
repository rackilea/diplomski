List<Integer>  transList = Collections2.filter(list, new Predicate<Integer>() {
                @Override
                public boolean apply(@Nullable Integer integer) {
                   return integer % 2 == 0;
                }
            });