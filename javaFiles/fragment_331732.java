// Rename and overwrite.
   documentListEntry.setTitle(new PlainTextConstruct(getGoogleDocTitle(checksum, date, version)));
   uploader = new ResumableGDataFileUploader.Builder(client, createUploadUrl, mediaFile, documentListEntry)
   .title(getGoogleDocTitle(checksum, date, version))
   .chunkSize(DEFAULT_CHUNK_SIZE).executor(executor)
   .trackProgress(listener, PROGRESS_UPDATE_INTERVAL).requestType(ResumableGDataFileUploader.RequestType.UPDATE)
   .build();