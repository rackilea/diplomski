public void addCuestionarioToDb(){
  for (webResultCuestionario currentItem: CuestionarioArray){
    int cis = Integer.parseInt(currentItem._id)-1;   // just added the -1 here and runs perfect
    db.insertCuestionario(CuestionarioArray.get(cis).pregunta,  CuestionarioArray.get(cis).respuesta);
  }
}