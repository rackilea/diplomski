List<List<String>> resultAlbum = qm1.getAlbums();

List<String> albumInfo;
String name, id;
List<<List<String>> resultInfo = new ArrayList<List<String>>();
for (int i = 0; i<= resultAlbum.size(); i++){
    //get on album row
    albumInfo = resultAlbum.get(i);

    name = albumInfo.get(0);
    id = albumInfo.get(1);

    //Get the info for this album and add into the list
    resultInfo .add(qm.getAlbumInfo(name, id));
}