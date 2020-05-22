int dx, dy;
if (dstY == srcY) dy = 0;
else dy = (dstY - srcY) / Math.abs(dstY - srcY);
if (dstX == srcX) dx = 0;
else dx = (dstX - srcX) / Math.abs(dstX - srcX);

while (srcX != dstX || srcY != dstY) {
  srcX += dx; srcY += dy;
  if (isPiece(srcX, srcY))
    return true;
}
return false;