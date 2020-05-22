if (!download.exists())
            if (!download.mkdirs()) {
                throw new ExternalStorageSetupFailedException("Download sub-directories could not be created");
            }
        }
        Download.download(new URL(file.getUrl() + file.getPatch()), file.getPath(), file.getName(), true);