public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        String input;
        boolean looper = true;
        DecimalFormat f = new DecimalFormat("#.00");
        ArrayList<Desktop> desktopList = new ArrayList<>();
        ArrayList<Laptop> laptopList = new ArrayList<>();

        while (looper) {
            System.out.println("");
            System.out.println("******************* Artificial Intelligence Co. *************************");
            System.out.println("1. Add Information for new Desktop");
            System.out.println("2. Add Information for new Laptop");
            System.out.println("3. Display all computer information");
            System.out.println("4. Quit");
            System.out.println("5. Credits");
            System.out.println("*************************************************************************");

            input = scan.nextLine();

            switch (input) {
                case "1":
                    System.out.println("");
                    System.out.println("=========================================================================");
                    System.out.println("Information for new Desktop");
                    System.out.println("=========================================================================");

                    Desktop xx = new Desktop();
                    boolean loop = true;


                    while (loop) {
                        System.out.print("What is the Computer ID: ");
                        xx.setComputerID(scan.nextLine().toUpperCase());

                        if ((xx.getComputerID().startsWith("D")) && (xx.getComputerID().length() == 4)) {
                            loop = false;
                        } else {
                            System.out.println("Computer ID should start with a letter \"D\". and have 4 characters.");
                            System.out.println("");
                        }
                    }

                    loop = true;
                    while (loop) {
                        System.out.print("What is the Processor Speed: ");
                        xx.setCPUspeed(scan.nextLine().toUpperCase());
                        try {
                            if (StringisDouble(xx.getCPUspeed().substring(0, (xx.getCPUspeed().length() - 2))) ||
                                    StringisDouble(xx.getCPUspeed().substring(0, (xx.getCPUspeed().length() - 3)))) {   //checks the value before GHZ or HZ if its a double
                                if (xx.getCPUspeed().endsWith("GHZ") || xx.getCPUspeed().endsWith("HZ")) {
                                    loop = false;
                                } else {
                                    System.out.println("CPU Speed input should end with \"GHZ\" or \"HZ\".");
                                    System.out.println("");
                                }
                            } else {
                                System.out.println("CPU Speed input should contain a decimal or number followed by  a \"GHZ\" or a \"HZ\".");
                                System.out.println("");
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("CPU Speed input should contain a decimal or number followed by  a \"GHZ\" or a \"HZ\".");
                            System.out.println("");
                        }

                    }

                    loop = true;
                    while (loop) {
                        System.out.print("What is the RAM: ");
                        xx.setRAM(scan.nextLine().toUpperCase());
                        try {
                            if (StringisInteger(xx.getRAM().substring(0, (xx.getRAM().length() - 2)))) {        //checks the value if it is numeric and ending with GB or MB
                                if (xx.getRAM().endsWith("GB") || xx.getRAM().endsWith("MB")) {
                                    loop = false;
                                } else {
                                    System.out.println("RAM input should have a numeric value and end with \"GB\" or \"MB\".");
                                    System.out.println("");
                                }
                            } else {
                                System.out.println("RAM input should have a numeric value and end with \"GB\" or \"MB\".");
                                System.out.println("");
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("RAM input should have a numeric value and end with \"GB\" or \"MB\".");
                            System.out.println("");
                        }


                    }

                    loop = true;
                    while (loop) {
                        System.out.print("What is the Harddisk size: ");
                        xx.setHarddisk(scan.nextLine().toUpperCase());
                        try {
                            if (StringisInteger(xx.getHarddisk().substring(0, (xx.getHarddisk().length() - 2)))) {        //checks the value if it is numeric and ending with GB or MB
                                if (xx.getHarddisk().endsWith("GB") || xx.getHarddisk().endsWith("TB")) {
                                    loop = false;
                                } else {
                                    System.out.println("Harddisk input should have a numeric value and end with \"GB\" or \"TB\".");
                                    System.out.println("");
                                }
                            } else {
                                System.out.println("Harddisk input should have a numeric value and end with \"GB\" or \"TB\".");
                                System.out.println("");
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("Harddisk input should have a numeric value and end with \"GB\" or \"TB\".");
                            System.out.println("");
                        }
                    }


                    loop = true;
                    while (loop) {
                        System.out.print("What is the Monitor: ");
                        xx.setMonitor(scan.nextLine().toUpperCase());
                        if (xx.getMonitor().equals("CRT") || xx.getMonitor().equals("LCD")) {
                            loop = false;
                        } else {
                            System.out.println("Please enter in CRT or LCD only.");
                            System.out.println("");
                        }
                    }

                    loop = true;
                    while (loop) {
                        try {
                            System.out.print("What is the price: $");
                            xx.setPrice(Double.parseDouble(scan.nextLine()));
                            loop = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Price input should be numeric.");
                            System.out.println("");
                        }
                    }

                    desktopList.add(xx);

                    System.out.println("Information successfully added.");
                    System.out.println("");
                    System.out.println("");
                    break;

                case "3":
                    int DesktopCounter = 1;
                    int LaptopCounter = 1;

                    System.out.println("");
                    if (desktopList.isEmpty()) {
                        System.out.println("No desktop added!");
                        System.out.println("");
                    } else {
                        for (int i = 0; i < desktopList.size(); i++) {
                            System.out.println("");
                            System.out.println("Desktop " + DesktopCounter);
                            System.out.println("Computer ID: " + desktopList.get(i).getComputerID());
                            System.out.println("Processor Speed: " + desktopList.get(i).getCPUspeed());
                            System.out.println("RAM: " + desktopList.get(i).getRAM());
                            System.out.println("Harddisk:" + desktopList.get(i).getHarddisk());
                            System.out.println("Monitor: " + desktopList.get(i).getMonitor());
                            System.out.println("Price: $" + f.format(desktopList.get(i).getPrice()));
                            DesktopCounter++;
                        }
                    }
                    break;
            }
        }
    }

    private static boolean StringisInteger(String substring) {return true;}

    private static boolean StringisDouble(String substring) { return true; }