Toidubaas nt = new Toidubaas(); //if i add constructor method, im getting error here, saying the constructor is undefined

nt.rbMeal.set(rs.getString("Toidu"));
nt.rbCal.set(rs.getInt("Kalorid"));
nt.rbProt.set(rs.getInt("Valgud"));
nt.rbCarb.set(rs.getInt("Süsivesikud"));
nt.rbFat.set(rs.getInt("Rasvad"));
toidudata.add(nt);