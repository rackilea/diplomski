//create a new person
Dabl resultRow = new Dabl();

//set that person's attributes
resultRow.id = json_data.getInt("id_DAB"); 
resultRow.libdab = json_data.getString("Libelle_DAB");
resultRow.etat = json_data.getString("etat");
resultRow.des= json_data.getString("description");
resultRow.zone= json_data.getString("zone");