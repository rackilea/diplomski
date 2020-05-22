DownloadManager.Request request = new DownloadManager.Request(Uri.parse( url ));

        request.setDescription(title);
        request.setTitle(title);


        request.setDestinationUri(Uri.fromFile(f));

        img_d_id = manager.enqueue(request);