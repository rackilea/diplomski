Arttextjn f = new Arttextjn();
f.setPArtId(KAMPARTIKEL.ART_ID);

var result =
dsl.select(KAMPARTIKEL.ARTNR, KAMPARTIKEL.ARTNRKAMP, f.asField())
   .from(KAMPARTIKEL)
   .fetch();