City scity;
do {
    System.out.print("Choose City: ");
    inputCity = userinput.nextLine();
    scity = search(cities, inputCity);
} while (scity == null);