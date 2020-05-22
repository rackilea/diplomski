public class ReservoirExample {
  private Random random = new Random();

  public int[] sample(int k, int[] array) {

    int[] reservior = new int[k];

    int i;
    for(i=0; i<k; i++){
      reservior[i] = array[i];
    }

    int j=0;
    for(; i<array.length; i++){
      j = random.nextInt(i);

      if(j< k){
        reservior[j] = array[i];
      }
    }

    return reservior;
  }
}