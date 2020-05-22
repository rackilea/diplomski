private void checkOffCode(String pChode) {
    final long[] percent = {0};
    APIGettingPosts apiGettingPosts = new APIGettingPosts(MainActivity.this, "get_off_code.php");
    apiGettingPosts.getOffCode(new APIGettingPosts.OnOffCodeReceived() {
        @Override
        public void onReceived(List<Posts> posts) {
            if (posts == null || posts.isEmpty()) {
                // There is no value on sever...
            } else {
                for (int i = 0; i < posts.size(); ++i) {

                    // If the code in serve is equal with pCode],
                    // change the price value....

                    if (pChode.equals(posts.get(i).getCode())) {
                        percent[0] = Long.valueOf(posts.get(i).getPercent());
                    }
                }
            }
            if (percent[0] != 0) {
                // update price value...
                price = price - price * percent[0] / 100;
                Log.e("Success >>", String.valueOf(price));
            } else {
                Log.e("Failure >>", String.valueOf(price));
            }
        }
    });
}

btnPurchase.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        checkOffCode("MYCODE");
    }
});