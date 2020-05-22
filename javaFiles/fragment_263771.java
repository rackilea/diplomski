String squery="select date_demande as {d.date_demande},nom as {c.nom}, prénom as {c.prénom} from Demande d , Candidat c   
                where d.id_candidat=c.id_candidat";
SQLQuery query=session.createSQLQuery(squery);
query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
Map<String,Object> row = null;
List data = query.list();
for (Object object : data) {
     row= (Map<String,Object>)object;
     System.out.println("date_demande: " + row.get("date_demande"));
     System.out.println("nom: " + row.get("nom"));
     System.out.println("prénom: " + row.get("prénom"));
}