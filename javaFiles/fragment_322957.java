public Aluno(String data) {
   String items = data.split(":");
   nome = items[0];
   estado = items[1];
   montanteMax = Float.parseFloat(items[2]);
}