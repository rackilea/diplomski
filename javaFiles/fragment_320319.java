static int pick;
    public static void main(String[] args) {
        ArrayList al = new ArrayList(); 
        Random rand = new Random();

        for (int j = 0; j<10; j++)
        {
            pick = rand.nextInt(100);
            al.add(pick);
        }

        System.out.println("Contents of al: " + al);
     }