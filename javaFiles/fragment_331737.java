static class Aggregate {
   private long count = 0L;
   private double sum = 0L;
   double average() { return sum / count; }
   void merge(Aggregate other) {
     count += other.count;
     sum += other.sum;
   }
   void add(int count, double value) {
     this.count += count;
     this.sum += count * value;
   }
 }
}

requests.stream().collect(
   Aggregate::new,
   (aggr, request) -> aggr.add(request.getCount(), request.getPrice()),
   Aggregate::merge)
 .average();