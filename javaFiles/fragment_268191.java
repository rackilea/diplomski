for(int i=0;i<btArray.length;i++){
    image = createImage(new FilteredImageSource(source.getSource(),
          new CropImageFilter((i%4)*width/4, (i/4)*height/4, width/4, height/4)));


    btArray[i]=new JButton(new ImageIcon(image));
}