for(int f = 0; f < len3; f++) {
    for(int g = f; g < len3; g++) {
        if(primeNumbers.get(f) + primeNumbers.get(g) == index) {
            System.out.println("Your two prime factors that add up to " + index + " are: ");
            System.out.println(primeNumbers.get(f) + " & " + primeNumbers.get(g));
        }
    }
}