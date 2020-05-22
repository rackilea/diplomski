private static void process(String command) {
    command = command.substring(0, command.length() - 1);

    String[] splitted = command.split("\\s+");

    for (String str : splitted) {
      System.out.println(str);
    }

    System.out.println(Arrays.toString(splitted).replace(" ", ""));
  }

  public static void main(String[] args) {
    process("Boolean b = new Boolean(true); ");
  }