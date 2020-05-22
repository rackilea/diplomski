Glide.with(appCtx)
        .load(sourceImageUri)
        .asBitmap()
        .fitCenter()
        .into(new FileTarget(to, 1024, 768) {
            @Override
            public void onFileSaved() {
                // do anything, or omit this override if you want
            }
        });