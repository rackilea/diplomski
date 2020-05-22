public static void main(String[] args) throws Exception {

    int size = 10;

    double [][] array = new double[100][1];

    for(int i=0; i<100; i++) {
      array[i] = new double[size];
      size = size * 2;
      System.out.println("Allocating: " + size);
      Thread.sleep(1000);
    }

  }