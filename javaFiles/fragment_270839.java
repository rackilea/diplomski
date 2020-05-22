firstAthlete.getShoes().forEach(shoe1 ->
    secondAthlete.getShoes().stream().filter(shoe2 -> 
        shoe1.getBrand().equals(shoe2.getBrand()) && shoe1.getColor().equals(shoe2.getColor()))
    ).forEach(shoe2 -> {
        shoe1.setSomeNumber(shoe1.getSomeNumber() + shoe2.getSomeNumber());
        shoe1.setSomeOtherNumber(shoe1.getSomeOtherNumber() + shoe2.getSomeOtherNumber());
    })