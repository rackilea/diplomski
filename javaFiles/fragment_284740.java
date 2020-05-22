if (blobKeys == null || blobKeys.isEmpty()) {
         res.sendRedirect("/");
     } else {
         //todo add the user
         ImagesService imagesService = ImagesServiceFactory.getImagesService();
         ServingUrlOptions servingOptions = ServingUrlOptions.Builder.withBlobKey(blobKeys.get(0));
         String servingUrl = imagesService.getServingUrl(servingOptions);
         res.sendRedirect(servingUrl);
        // res.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
     }