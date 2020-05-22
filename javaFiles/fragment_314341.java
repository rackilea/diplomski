toidudata.add(new Toidubaas(     //Getting error here, if im not using constructor method, saying the method is undefined.
rs.getString("Toidu"),
rs.getInt("Kalorid"), 
rs.getInt("Valgud"),
rs.getInt("Süsivesikud"), 
rs.getInt("Rasvad")));
tbTabelview.setItems(toidudata);