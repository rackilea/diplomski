List<Integer> list = new ArrayList<>();
Scanner scanner = new Scanner(System.in);

// keep looping until -1 is encountered
while (true) {
        int temp = scanner.nextInt();
        if (temp == -1) {
            break;
        }
        list.add(temp);
}

// Printing the array list
System.out.println(list);

// closing the scanner is important
scanner.close();