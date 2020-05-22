for (Boot boot : boten) {
    if (boot instanceof ZeilBoot) {
        if (minimumAantalMasten > ((ZeilBoot) boot).getAantalMasten()) {
            System.out.println(boot.toString());
        }
    }
}