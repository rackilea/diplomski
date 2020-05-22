static <T> Collector<T,?,Double> averagingWeighted(ToDoubleFunction<T> valueFunction, ToIntFunction<T> weightFunction) {
    class Box {
        double num = 0;
        long denom = 0;
    }
    return Collector.of(
             Box::new,
             (b, e) -> { 
                 b.num += valueFunction.applyAsDouble(e) * weightFunction.applyAsInt(e); 
                 b.denom += weightFunction.applyAsInt(e);
             },
             (b1, b2) -> { b1.num += b2.num; b1.denom += b2.denom; return b1; },
             b -> b.num / b.denom
           );
}