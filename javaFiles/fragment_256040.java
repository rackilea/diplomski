ArrayList<Thumbnail> tmp = new ArrayList<>();
for (Thumbnail thumbnail : videoList1){
    for (Giphy giphy : giphyList) {


        if (thumbnail.getVideoID().equals(giphy.getVideoID())) {

            thumbnail.setThumbUp(giphy.getThumbUp());
            thumbnail.setThumbDown(giphy.getThumbDown());
            tmp.add(thumbnail);
        }
    }
}
videoList1.addAll(tmp);