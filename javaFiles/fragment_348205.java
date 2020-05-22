MyApplication.getInstance().getFetch().getDownloads(downloads -> {

    downloadList.set(downloads);
    for (int i = 0; i < downloadList.get().size(); i++) {
       //...
    }
    // ... DO your post processing here

});