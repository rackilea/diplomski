public static void shut_server(String lien) 
{
      try {

        Process child = Runtime.getRuntime().exec(lien+"/shutdown.sh");
        System.out.println("Serveur est atteins");
    } catch (IOException ex) {
        Logger.getLogger(Installation.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("erreur de demarrage");
    }
}