public List<Commandeclient> findCommandeclient() {
    return em.createQuery("Select c FROM Commandeclient c").getResultList();
}
Resultat = CommandeclientFC.findCommandeclient();
for (Commandeclient com : Resultat) {
}