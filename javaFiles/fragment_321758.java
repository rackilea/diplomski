ImageView imageView = new ImageView();
Services.get(PicturesService.class).ifPresent(service -> {
    // once selected, the image is visualized
    service.loadFromGallery().ifPresent(image -> imageView.setImage(image));
    // and the file can be shared
    service.getImageFile().ifPresent(file -> 
      Services.get(ShareService.class).ifPresent(share -> 
          share.share("image/jpeg", file)));
 });