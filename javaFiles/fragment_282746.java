String nomePais;
String nome;
List<String> nomePaisList;
DatabaseReference paisNomeContinentes = mDatabase.child("Continente").child(Constants.PAISES_EUROPA).child("Paises");             // C1 - ÁFRIA        (Constants.PAISES_AFRICA)
    ValueEventListener valueEventListener1 = new ValueEventListener() {                                                          // C2 - ÁSIA         (Constants.PAISES_ASIA)
        @Override                                                                                                               // C3 - ANTÁRTIDA    (Constants.PAISES_ANTARTIDA)
        public void onDataChange(DataSnapshot dataSnapshot) {                                                                   // C4 - AMÉRICA      (Constants.PAISES_AMERICA)
                                                                               // C5 - EUROPA       (Constants.PAISES_EUROPA)
                                                                                                                               // C6 - OCEANIA      (Constants.PAISES_OCEANIA)
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                nomePais = ds.child("Continente").getValue(String.class);
                if(nomePais.equals("AMERICA") || nomePais.equals("EUROPIA") {
                    nome = nomePais;
                    fetch(nome);
                 } // Suppose user selects continent AMERICA & EUROPIA
            }

void fetch(String n) {
   Query paisNome = mDatabase.child("continentes").child(Constants.PAISES_EUROPA).child("Paises").child("P;             1").child("Nome").equalTo(n);
   ValueEventListener valueEventListener1 = new ValueEventListener() {                                                          
    @Override                                                                                                               
    public void onDataChange(DataSnapshot dataSnapshot) {                                                                   
        nomePaisList = new ArrayList<>();                                                                     
        nome = dataSnapshots.getValue().toString();
        nomePaisList.add(nome);

    }
}