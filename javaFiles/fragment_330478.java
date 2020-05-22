public class StandDev {

  public double standardDevioation(int[] numbers){
    int count = numbers.length;
    double sum = 0.0;
    for (int i = 0; i < count; i++){
      sum += numbers[i];
    }

    double mean = sum / count;

    double sumDiff = 0.0;
    for (int i = 0; i< count; i++){
      sumDiff += Math.pow(numbers[i] - mean,2);
    }

    return Math.sqrt (sumDiff/count);
  }

  public static void main(String[] args) {
    int[] numbers =  {-5, 1, 8, 7, 2};
    StandDev standDev = new StandDev();
    System.out.println(standDev.standardDevioation(numbers));
  }
}