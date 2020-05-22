for (int i = 0; i < enBoundingBoxes.size(); i++) {
Rectangle tempBBox = enBoundingBoxes.get(i);

if (d.intersects(tempBBox) && en.visible == true && !en.isAlive == false && !p.hitting) {
    hitmang(hit);
    p.hitting = true;
   }
}

etc etc...