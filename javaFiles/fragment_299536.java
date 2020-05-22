ResumableGDataFileUploader uploader = new ResumableGDataFileUploader.Builder(
                service, new URL("http://uploads.gdata.youtube.com/resumable/feeds/api/users/default/uploads"), ms, newEntry)
                .title(videoTitle)
                .trackProgress(listener, 1000)
                .chunkSize(10000000)
                .build();

        Future<ResumableHttpFileUploader.ResponseMessage> futureResponse = uploader.start();

        while (!uploader.isDone()) { Thread.sleep(1000); }

        switch(uploader.getUploadState()) {
            case COMPLETE:
                ResumableHttpFileUploader.ResponseMessage responseMessage = futureResponse.get();
                VideoEntry videoEntry = new VideoEntry();
                videoEntry.parseAtom(new ExtensionProfile(), responseMessage.getInputStream());
                youtubeURL = videoEntry.getHtmlLink().getHref();
                logger.info("Uploaded successfully");
                return youtubeURL;
            case CLIENT_ERROR: logger.error("Upload Failed"); return null;
            default: logger.warn("Unexpected upload status"); return null;
        }