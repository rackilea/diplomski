for (int i = 1; i <= numElt; i++) {
    x = new DataElement(...); //... means whatever constructor parameters it takes.
    System.out.print("Enter next element ");
    num = input.nextInt();
    x.setNum(num);

    tree.insert(x);
}