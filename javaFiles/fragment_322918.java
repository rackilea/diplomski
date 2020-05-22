public void drawImage(Bitmap img, int x, int y, float angle)
{
  transform.setRotate(angle, img_width/2, img_height/2);
  transform.postTranslate(x, y);
  canvas.drawBitmap(img, transform, null);
}