while(scan.hasNext()) {

    String line = scan.nextLine(); 
    String[] words = .split(" ");

    double num1 = Double.parseDouble(words[1]);
    double num2 = Double.parseDouble(words[2]);
    double num3 = Double.parseDouble(words[3]);

    double average = (num1 + num1 + num3) / 3;

    System.out.println(line);
    System.out.println("average is : " + average);
}