if (SkillLevel > 1) {
    System.out.println("Would you like to sign up for medical y/n?");
    Medical = sc.next().charAt(0); // make sure you define Medical as char
    if (Medical == 'y') {
        TotalPay = TotalPay - 23.50;
        System.out.println("\nMedical Insurance cost: -$23.50");
    }
}