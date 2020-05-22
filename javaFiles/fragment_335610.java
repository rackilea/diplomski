DisplayImageOptions  options = new DisplayImageOptions.Builder()
                        .showImageOnLoading(R.drawable.ic_stub)
                        .showImageForEmptyUri(R.drawable.ic_empty)
                        .showImageOnFail(R.drawable.ic_error)
                        .cacheInMemory(true)
                        .cacheOnDisc(true)
                        .considerExifParams(true)
                        .build();