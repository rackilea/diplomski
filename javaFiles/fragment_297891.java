Path2D path = new Path2D.Double();

path.moveTo(valoresX[0], valoresY[0]);
for(int i = 1; i < valoresX.length; ++i) {
   path.lineTo(valoresX[i], valoresY[i]);
}
path.closePath();