/** The Constant tdbDirectory. */
public static final String tdbDirectory = "C:\\TDBLoadGeoCoordinatesAndLabels"; 

/** The Constant dbdump0. */
public static final String dbdump0 = "C:\\Users\\Public\\Documents\\TDB\\dbpedia_3.8\\dbpedia_3.8.owl";

/** The Constant dbdump1. */
public static final String dbdump1 = "C:\\Users\\Public\\Documents\\TDB\\geo_coordinates_en\\geo_coordinates_en.nt";

 ...

Model tdbModel = TDBFactory.createModel(tdbDirectory);<\n>

/*Incrementally read data to the Model, once per run , RAM > 6 GB*/
FileManager.get().readModel( tdbModel, dbdump0);
FileManager.get().readModel( tdbModel, dbdump1, "N-TRIPLES");
FileManager.get().readModel( tdbModel, dbdump2, "N-TRIPLES");
FileManager.get().readModel( tdbModel, dbdump3, "N-TRIPLES");
FileManager.get().readModel( tdbModel, dbdump4, "N-TRIPLES");
FileManager.get().readModel( tdbModel, dbdump5, "N-TRIPLES");
FileManager.get().readModel( tdbModel, dbdump6, "N-TRIPLES");
tdbModel.close();