public class Read {
  public static void main (String [] args) {
    try (
      Scanner scanner = new Scanner(System.in);
    ) {
      int nbin = scanner.nextInt();
      int cbin = scanner.nextInt();
      int data[][] = new int[nbin][2];
      for (int i = 0; i < nbin; ++i) {
        data[i][0] = i + 1;
        data[i][1] = scanner.nextInt();
      }
    }
  }
}