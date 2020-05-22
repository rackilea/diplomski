try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter the number of elements to enter into an array");
        int userCount = scanner.nextInt();
        System.out.println("Enter the number one by one");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < userCount; i++) {
            arrayList.add(scanner.nextInt());
        }

        ArrayList<Integer> destinationList = new ArrayList<>(arrayList);
        // Print elements in the Array List
        for (Integer number : destinationList) {
            System.out.println("The numbers are");
            System.out.println(number);
        }

}