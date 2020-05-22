public Object instantiateItem(ViewGroup container, int position) {

        ImageViewPlus img_news_image;
        TextView txt_news_title;
        TextView txt_news_description;

        inflater = (LayoutInflater) mActivity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewLayout = inflater.inflate(R.layout.detail_news_page, null);

        img_news_image = (ImageViewPlus) viewLayout
                .findViewById(R.id.img_detail_news_image);
        txt_news_title = (TextView) viewLayout
                .findViewById(R.id.txt_detail_news_title);
        txt_news_description = (TextView) viewLayout
                .findViewById(R.id.txt_detail_news_description);

        Log.d("TAG :", "instantiateItem");

        imageLoader.displayImage(newsObjects.get(position).getNews_image(),
                img_news_image);

        Toast.makeText(mActivity.getApplicationContext(),
                Constantz.newsObjects.get(position).getNews_id() + "",
                Toast.LENGTH_SHORT).show();

        txt_news_title.setText(newsObjects.get(position).getNews_title());
        txt_news_description.setText(newsObjects.get(position)
                .getNews_description());
        container.addView(viewLayout);

        return viewLayout;
    }