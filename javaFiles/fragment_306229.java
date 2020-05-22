public static void selection(List<Performer> listperformer) {
    int i = 0;
    List<Performer> idlist = new ArrayList<Performer>();
    Scanner sclocal = new Scanner(System.in);

    if (listperformer.isEmpty() == true) {
        System.out.println("- empty -");
        return;
    } else {
        int id;//This is being used as an offset, so I recommend you rename it to "offset"
        System.out.println("Enter ID:");

        while (sclocal.hasNext()) {
            try {
                id = sclocal.nextInt();
                if (listperformer.size() <= id || id < 0) {
                    System.out.println("Invalid input! You requested the element at offset [" + id + "], but the max offset available is [" + (listperformer.size()-1) + "]. Exiting.");
                    return;
                } else {
                    System.out.println("Input is valid. We have added the offset identifier [" + id + "] to listperformer.");
                    idlist.add(listperformer.get(id));
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input!");
                sclocal.nextLine();//throw away the invalid input so that we can await for the next input
            }
            System.out.println("Enter ID:");
        }
    }
}