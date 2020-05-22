public void wijzigCijfer(String nm, Double nweCijfer){
    // Assuming that you want to find by nm, as shown in your demo
    for (Leerling l : leerlingen) {
        if (l.getNaam().equals(nm)) { // or use equalsIgnoreCase
            l.setCijfer(nweCijfer);
        }
    }
}