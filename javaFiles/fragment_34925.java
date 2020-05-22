Collections.shuffle(RandomNumsList);
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> numsAlreadyUsed = new ArrayList<Integer>();
    String letter;
    int index;
    for (index = 0; index<RandomNumsList.size(); index++) {
        System.out.println("Press enter for the next number!");
        scan.nextLine()
        int x=RandomNumsList.get(index);
        numsAlreadyUsed.add(x);

        if (x>0 && x<=15) { 
            letter=("B");
        } else if (x>15 && x<=30) { 
            letter=("I");
        } else if (x>30 && x<=45) {
            letter=("N");
        }else if (x>45 && x<=60) { 
            letter=("G");
        }else if (x>60 && x<=75) { 
            letter=("O");
        }
        // no need to repeat this line in every branch of the if statement!
        System.out.println (letter+x);
    }