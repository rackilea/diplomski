for(short i=0;i<pin.length;i++) {
    if (pin[i].getName().equals(x)) {
        System.out.println("Όνομα"+"\t"+"Μήκος"+"\t"+"Πλάτος"+"\t"+"Εκτόπισμα"+"\t"+"Έτος Κατασκευής"+"\t"+"Μέγιστη Ταχύτητα"+"\t"+"Όνομα ιδιοκτήτη");
        System.out.println("name"+"\t"+pin[i].getLength()+"\t"+pin[i].getWidth()+"\t"+pin[i].getDisplacement()+"\t"+pin[i].getYear()+"\t"+pin[i].getSpeed()+"\t"+pin[i].getOwners_name());
    }
}