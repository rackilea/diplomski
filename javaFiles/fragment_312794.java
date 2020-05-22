try {
        // Objekt erzeugen
        ErgaenztesAuto ErgaenztesAuto1 = new ErgaenztesAuto("Rene", "BMW", "Rot", 1981, 90, 10, "Berlin", "ABCD");
        ErgaenztesAuto ErgaenztesAuto2 = new ErgaenztesAuto("Rene", "Audi", "Gelb", 2010, 70, -20000, "Muenchen", "WXYZ");
        ErgaenztesAuto1.meldung();
        ErgaenztesAuto2.meldung();
    } catch (IllegalArgumentException e) {
        System.out.println("Meine Exception trat auf: " + e.getMessage());
    } finally {
        System.out.println("I'M RUNNING AFTER EXCEPTION !!");
        // OTHER CODE LOGIC
    }