public class BioHomework {
  public static void main(String[] args) {
    if(args.length < 2) {
       throw new IllegalArgumentException("two args required");
    }
    String sequence = args[1];
    if (!sequence.toLowerCase().matches("[atgc]{10,20}")){
      throw new IllegalArgumentException("second arg should be 'atgc' string between 10 and 20 characters");
    }
    if ("u".equals(args[0])) {
      System.out.println(sequence.toUpperCase());
    } else if ("l".equals(args[0])) {
      System.out.println(sequence.toLowerCase());
    } else {
      throw new IllegalArgumentException("first argument must be either 'u' or 'l'");
    }

  }
}