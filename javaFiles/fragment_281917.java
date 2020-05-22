public class QuizAveragee {
  private static final int NAMELIMIT = 5;

  public static void main(String[] args) {
    //these lines are not needed but OP asked for the values to be stored in arrays
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Double> averages = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    for (int i = 0; i < NAMELIMIT; i++) {
        String line = in.nextLine();
        String[] words = line.split(" ");
        String name = words[0] + " " + words[1];
        double average = findAverage(words[2], words[3], words[4], words[5], words[6]);
        System.out.println("Name : " + name + " Quiz Avg: " + average);

        //these lines are not needed but OP asked for the values to be stored in arrays
        names.add(name);
        averages.add(average);
    }
  }

  private static double findAverage(String a, String b, String c, String d, String e) {
    double sum = Double.parseDouble(a) + Double.parseDouble(b) + Double.parseDouble(c) + Double.parseDouble(d) + Double.parseDouble(e);
    return (sum / NAMELIMIT);
  }
}