ImageDownloader imageDownloader = new ImageDownloader();
    imageDownloader.setMode(ImageDownloader.Mode.CORRECT);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.picture);

    imageView.setLayoutParams(new GridView.LayoutParams(140, 140));
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    imageView.setPadding(4, 4, 4, 4);

    List<ImageSize> images = this.pictures.get(position).getImages();

    imageDownloader.download(images.get(images.size()-3).getSource(), imageView);