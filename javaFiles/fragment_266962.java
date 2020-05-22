private boolean intersect(Polygon[] polygons, Line[] the_path, int i, int j) {
  int k = 0;

  for (i = 0; i < polygons.length; i++) {
    for (j = 0; j < polygons[i]._lines.length; j++) {
      for (k = 0; k < the_path.length; k++) {
        if (polygons[i]._lines[j].intersect(the_path[k])) {
          return true;
        }
      }
    }
  }

  return false;
}