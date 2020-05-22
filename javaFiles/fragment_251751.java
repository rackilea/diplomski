public Personne findUsingEnhancedForLoop(String name) {

  for (Personne personne : listePersonne) {
     if (personne.getPersonne().equals(name)) {
          return personne;
     }
 }
 return null;
}