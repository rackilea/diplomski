class Map {
  Long id
}

class MapEntry {
  Long id

  Long mapId  //better to use Key for parent map

  int x
  int y
  MapEntryType type //if you have different elements of map

  //some other fields / payload
}