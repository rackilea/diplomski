//constructor, callback whatever
imageSource = new MemoryImageSource(data.width,data.height,rawdata,0,data.width);
...
//Paint method of a JFrame or what ever ...
...
image img = createImage(imageSource);
setBounds(100,100,img.getWidth(null),img.getHeight(null));
createBufferStrategy(2);

BufferStrategy strategy = getBufferStrategy();

Graphics gr = strategy.getDrawGraphics();           
gr.drawImage(img, 0, 0, null);
gr.dispose();

strategy.show();