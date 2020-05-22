try {
    ConnectLogin dao = new ConnectLogin(); 
    user = dao.getContato(email, senha);
}
catch ( Exception e ){
    System.out.println(e.getMessage()); 
}