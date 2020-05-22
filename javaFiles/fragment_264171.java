while(thesum < inputmax) {
    System.out.println("Enter each of weight: ");
    inputweight = sc.nextInt();

    while (inputweight < 0) {
        System.out.println("Enter positive number of weight: ");
        inputweight = sc.nextInt(); 
    }

    // Check if the the total of weight is greater than the maximum before adding the weight of last passenger into the sum
    if (thesum+inputweight < inputmax)
        thesum += inputweight;
        count++;
    } else {
        break;
    }
}