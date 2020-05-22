BiPredicate<Double, Double> biPredicate = (e, a) -> Math.abs(e - a) < 1.0e-6;
boolean isEqual = 
         IntStream.range(0, firstList.size())
                  .boxed()
                  .reduce(Boolean.TRUE,
                    (accumulator, i) -> Boolean.logicalAnd(accumulator, biPredicate.test(firstList.get(i), secondList.get(i))),
                    (a, b) -> {
                        throw new RuntimeException("not implemented");
                    });