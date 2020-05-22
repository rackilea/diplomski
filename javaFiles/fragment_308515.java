// declare it before the loop 
StringBuilder stringaFinale = new StringBuilder(200); // use appropriate size

//Inside the loop
stringaFinale.append(json_data.getString("id_Persons") + " " + json_data.getString("name") + " " + json_data.getString("address"));

//Get the value
stringFinale.toString();