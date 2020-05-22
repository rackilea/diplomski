public static House read(Scanner sc) {

        House h = null;
        String line = sc.next();

        if(line.equals("FOR RENT")) {
            h = RentalHouse.read(sc);
        }
        else if(line.equals("RENTED"){
            h = RentalHouse.read(sc);
            h.available = false;
        }
        else if(line.equals("FOR SALE"){
            h = OwnerOccupiedHouse.read(sc);
        }
        else { 
            //if(line.equals("SOLD"))
            h = OwnerOccupiedHouse.read(sc);
            h.available = false;
        }

        return h;

    }