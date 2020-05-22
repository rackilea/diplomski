//server url
      String imageURL = ""
     //array of images passed in constructor to append with url
      String arrayOfImages[] = imageId;                                                                                                               
      String completeImageURL = server + arrayOfImages[position];
                Picasso.with(context)
                        .load(completeImageURL)
                        .into(holder.img);