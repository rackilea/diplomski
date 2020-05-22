public static Object[] listenomclientfidelite() {
    final Vector<NomClient> requete = new Vector<NomClient>();
    try {
        c = Connexion.getCon();
        final String sql = "SELECT DISTINCT NOMCLIENT FROM CARTE_DE_FIDELITE INNER JOIN CLIENT ON CLIENT.IDCLIENT=CARTE_DE_FIDELITE.IDCLIENT";
        preStm = c.prepareStatement(sql);
        rs = preStm.executeQuery();
    } catch (final Exception e) {
        System.out.print("erreur" + e.getMessage());
    }
    try {
        requete.add(null);
        NomClient liste;
        while (rs.next()) {
            liste = new NomClient();
            liste.setNom(rs.getString(1));
            requete.add(liste);
            System.out.println("listenomclientfidelite, liste is : "+liste);
        }
        rs.close();
        preStm.close();
    } catch (final Exception e) {
        System.out.print("errorlistenom" + e.getMessage());
    }

    Collections.sort(requete);
    return requete.toArray(new Object[0]);
}