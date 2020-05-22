BufferedReader inFile = new BufferedReader(new FileReader("dogslist.txt"));
    String line;
    int count = 0;
    Dogs[] parlour = new Dogs[16];

    while((line = inFile.readLine()) != null)
    {
        if(line.trim().length() > 0){
            String[] field = line.split("#");

            if(field.length < 3){
                System.out.println("Invalid line encountered: " + line);
            }
            else{
                int age = Integer.parseInt(field[2]);
                parlour[count] = new Dogs(field[0],field[1],age);
                System.out.println(parlour[count]);
                count++;
            }
        }
    }