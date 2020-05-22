while(input.hasNext()) {
    System.out.print("Enter an integer or 'end' to finish: ");
    String next = input.next();
    if("end".equalsIgnoreCase(next)) {
        break;
    }

    int theInt = Integer.parseInt(next);
    ...