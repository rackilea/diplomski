for (int i=2; i<=Math.sqrt(nbr); i++) {
    if (nbr % i == 0) {
        // we found a number that divides evenly into nbr without 
        // any remainder, therefore this number is not a prime.
        return false;
    }
} 
return true;