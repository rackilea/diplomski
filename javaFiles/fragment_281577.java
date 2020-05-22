public static class Exam {
  final double mark;
  final double weight;

  public Exam(double mark, double weight) {
    this.mark = mark;
    this.weight = weight;
  }

  public double getTotal() {
    return mark * weight / 100;
  }

  public static double getAverage(Exam[] arr) {
    double sum = 0;
    for (int i=0; i < arr.length; i++) sum += arr[i].getTotal();
    return sum / arr.length;
  }

}