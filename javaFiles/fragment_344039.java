if(aCars.getBrand().charAt(0) == ch) {
        System.out.println("this is if");

        for(int i = 0; i< carsArray.length; i++) {
            carsArray[i] = aCars;
            System.out.println("carsArray[" + i + "]: " + carsArray[i]);
        }
    }
}