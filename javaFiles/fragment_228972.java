Observable.fromIterable(holders)
  .concatMap(holder -> {
    Observable.fromIterable(holder.images)
      .flatMap(image -> {
        // decode bitmap here
        uploadImage(bitmap)
        .map(url -> {
          image.url = url;
          return image;
        });
      })
      .toList()
      .map(list -> {
        holder.images = list;
        return holder;
      });
  })
  .toList(); // optional, if you need holders as a list