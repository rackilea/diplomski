for (int i = 0; i < returnValue.size(); i++) {
        String path = returnValue.get(i);

        System.out.println ( "path: " + path);

        Glide.with(this)
                .load(path)
                .onlyRetrieveFromCache(true)
                .into(imageView);

        break; // load only one image in the imageview
     }