if (read.hasNext()) {
  //if prevents NoSuchElementException
                    String petname = read.next();
                    System.out.println("Petname: " + petname);

                    int birthday = read.nextInt();
                    String species = read.next();
                    double bill = read.nextDouble();
                    String owner = read.next();
                    System.out.println("BirthDay" + birthday);
                    System.out.println("Name" + petname);
                    System.out.println("BIll" + bill);
                    System.out.println("Speci" + species);
                    System.out.println("Owner " + owner);
                }