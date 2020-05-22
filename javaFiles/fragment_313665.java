Boolean StudentMissing = True
for(int i = 0; i < sk1.getListenLaenge(); i++) {
  if(n_input.equals(sk1.getSchueler(i).getName()) || n_input.equals(sk1.getSchueler(i).getNachname())) {
    System.out.println(" " + sk1.getSchueler(i).getAlter());
    StudentMissing = False
    break;
  }
}
if(StudentMissing){
  System.out.println("Schüler existiert nicht oder ist nicht in dieser Klasse!");
}