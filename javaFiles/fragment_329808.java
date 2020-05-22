Image image = Image.createImage(path_to_img+"/img.PNG");

g.drawImage(image, x, y, Graphics.TOP | Graphics.LEFT);   // 1) Use drawImage function.

Sprite mainSprite = new Sprite(image); // 2) Use Sprite to display your image.
mainSprite.setRefPixelPosition(x, y);
mainSprite.paint(g);