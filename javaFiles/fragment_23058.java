public double getShip(double total, int code) {
    switch(code) {
        case 1: // Overnight Box
            return total + 16.95;
        case 2: // Express Box
            return total + 13.95;
        case 3: //Standard Box
            if(total >= 100.0) { // No shipping for orders >= $100
                return total;
            }

            return total + 7.95;
    }
}