try (FileWriter fileWriter = new FileWriter("G:\\test.txt")) {
            Scanner scn = new Scanner(System.in);

            while (true) {
                String string = scn.nextLine();

                if (string.equals("0")) {
                    break;
                } else {
                    fileWriter.write(string+"\n");
                }
            }
        }