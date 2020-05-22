public List rechercheValeurTarifs() throws Exception {
    List tarifs = null;
    try{

        tarifs = getHibernateTemplate().find("FROM FE_TARIF_IDF " +
                "WHERE FE_TARIF_IDF.D_ANNEE in (SELECT MAX (FE_EXERCICE_FISCAL.D_CEXER) FROM FE_EXERCICE_FISCAL);");

        if(tarifs == null)
        {
            tarifs = getHibernateTemplate().find("FROM FE_TARIF_IDF " +
                    "WHERE FE_TARIF_IDF.D_ANNEE in (SELECT MAX (FE_EXERCICE_FISCAL.D_CEXER-1) FROM FE_EXERCICE_FISCAL);");
        }
    } catch (Exception e){
    System.out.println(e.getStackTrace());
    }
    return tarifs;
}