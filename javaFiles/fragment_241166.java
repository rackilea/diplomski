for (int i = 0; i < b.length; i++) {
  var dist = Math.abs(b[i]-r);
  if (dist < min) {
    min = dist;
    index = i;
  }