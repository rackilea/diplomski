SingerDAO sDAO = new SingerDAO();
AlbumDAO aDAO = new AlbumDAO();

SingerEntity s1 = new SingerEntity(1,"Singer");
s1.addAlbum(new AlbumEntity(1,"a1","g1",1)); 
s1.addAlbum(new AlbumEntity(2,"a2","g2",1)); 
s1.addAlbum(new AlbumEntity(3,"a3","g3",1)); 
s1.addAlbum(new AlbumEntity(4,"a4","g4",1)); 
sDAO.insert(s1);