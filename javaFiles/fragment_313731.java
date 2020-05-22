String in = "3:2 2:26 1:11 8:4 4:25";
    String[] split = in.split(" ");
    int sum = 0;

    for(int i = 0; i < split.length; i++)
    {
        try {
            sum += Integer.parseInt(split[i].split(":")[1]);
        } catch(NumberFormatException e) {
            System.out.println("Input not a number");
        }
    }

    System.out.println(sum);