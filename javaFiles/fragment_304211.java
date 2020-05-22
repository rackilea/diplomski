public static void readFile() {
        String fileName = "F:\\document\\eclipse\\JavaAZ\\src\\VetManagement.txt";
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + fileName);
            System.exit(0);
        }
        String[] name = new String[100];
        String[] size = new String[100];
        String[] type = new String[100];
        String[] doctor = new String[100];
        double[] weight = new double[100];
        int[] age = new int[100];
        if (inputStream.hasNextLine()) {
            String[] nextLine = inputStream.nextLine().split(" ");
            int petCounter = 0;
            int doctorCounter = 0;
            String workingArray = new String(nextLine[0]);

            while(inputStream.hasNextLine()) {
                if(workingArray.equals("Pets")) {
                    nextLine = inputStream.nextLine().split(" ");
                    if (nextLine[0].equals("Doctors")) {
                        workingArray = "Doctors";
                        continue;
                    }

                    if (nextLine[0].equals("type")) {
                        type[petCounter] = nextLine[1];
                        //System.out.println(type);
                    }
                    else System.out.println("type error");

                    nextLine = inputStream.nextLine().split(" ");
                    if (nextLine[0].equals("size")) {
                            size[petCounter] = nextLine[1];
                            //System.out.println(size);
                    } 
                    else System.out.println("size error");

                    nextLine = inputStream.nextLine().split(" ");
                    if (nextLine[0].equals("name")) {
                            name[petCounter] = nextLine[1];
                            //System.out.println(name);
                    } 
                    else System.out.println("name error");

                    nextLine = inputStream.nextLine().split(" ");
                    if (nextLine[0].equals("weight")) {
                            weight[petCounter] = Double.parseDouble(nextLine[1]);
                            //System.out.println(weight);
                    } 
                    else System.out.println("weight error"); 

                    nextLine = inputStream.nextLine().split(" ");
                    if (nextLine[0].equals("age")) {
                            age[petCounter] = Integer.parseInt(nextLine[1]);
                            //System.out.println(age);
                    } 
                    else System.out.println("age error"); 

                    nextLine = inputStream.nextLine().split(" ");
                    if (nextLine[0].equals("doctor")) {
                            doctor[petCounter] = nextLine[1];
                            //System.out.println(doctor);
                    } 
                    else System.out.println("doctor error"); 
                    petCounter++;
                }
                else if(workingArray.equals("Doctors")) {
                    // CODE HERE
                    doctorCounter++;
                    break;
                }
            }
         }
        System.out.println("PET NAME: "+name[0]+" and its Weight: "+weight[0]);
        inputStream.close();
    }