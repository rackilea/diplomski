// Draw US Map
  String[] lines = loadStrings("Map2.csv");    // File containing coordinates to plot US Map

  mapGraphics = createGraphics(width, height);
  mapGraphics.beginDraw();
  mapGraphics.stroke(55);
  mapGraphics.strokeWeight(1);
  mapGraphics.smooth();

  String[] pieces = split(lines[0], ',');

  for ( int i = 0; i < lines.length; i++) {
    mapGraphics.fill(0);
    mapGraphics.beginShape();
    current = int(pieces[0]);

    while ( current == int(pieces[0]) & i < lines.length) {

      x = int(pieces[2]);
      y = int(pieces[1]);
      mapGraphics.vertex(width/1620.0 * x, height/1080.0 * y);
      i++;

      if ( i < lines.length) {
        pieces = split(lines[i], ',');
      }
    }
    mapGraphics.endShape();
  }

  // Add Lakes to Map
  String[] lines2 = loadStrings("water.csv");    // File containing coordinates to plot great lakes
  mapGraphics.smooth();
  mapGraphics.fill(22, 25, 180);

  String[] pieces2 = split(lines2[0], ',');
  for (int i = 0; i < lines2.length; i++)
  {
    mapGraphics.fill(110);
    mapGraphics.beginShape();
    current =  int(pieces2[0]);

    while (current == int(pieces2[0]) & i < lines2.length) {

      x = int(pieces2[2]);
      y = int(pieces2[1]);
      mapGraphics.vertex(width/1620.0 * x, height/1080.0 * y);
      i++;
      if (i < lines2.length) {
        pieces2 = split(lines2[i], ',');
      }
    }
    mapGraphics.endShape();
  }
  mapGraphics.endDraw();