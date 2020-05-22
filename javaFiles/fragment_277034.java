StringBuffer str = new StringBuffer();

    FileWriter output = new FileWriter("number.txt");

    Random r = new Random();
    for (int i = 1; i < 101; i++) {

        str.append(r.nextInt(100)).append('\n');

    }
    output.write(str.toString());
    System.out.println(str.toString());
    output.close();

    FileReader reader = new FileReader("number.txt");
    BufferedReader input = new BufferedReader(reader);

    String line;
    int total = 0;

    while ((line = input.readLine())!=null) {

        total += Integer.parseInt(line);
    }
    System.out.println(total);