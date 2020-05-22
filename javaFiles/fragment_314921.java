public class ObjectToSend implements Serializable {
    [...]
    public ObjectToSend(String prenomP, String nomP, int idGloregP, int indPersoP, boolean okP, String entiteP, int errorP){
       prenom = prenomP ;
       nom= nomP;
      idGloreg = idGloregP;
       indPerso = indPersoP; 
       ok = okP;
       entite= entiteP;
       error = errorP;  
  }
}