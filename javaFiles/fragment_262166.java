public class myAdapterDouble extends ArrayAdapter<Order> {
    private int[] colorWhite = new int[] { -0x1 };
    private int[] colors = new int[] { -0x1, -0x242425 };
    private int[] colorBlack = new int[] { -0x1000000 };
    private int[] colorTransparent = new int[] { android.R.color.transparent };
    private LayoutInflater lInflater;
    private ArrayList<Order> data;
    private Order o;
    private DisplayImageOptions options;
    private ImageLoader imageLoader;
    private ImageLoaderConfiguration config;
    private Context ctx;
    private Typeface tf;


    boolean posters, fixFont;
    float headerSize, timeSize, dateSize;
    int imageWSize;
    private String finaleColor;
    private String chooseColor;
    private String final_ep;

    public myAdapterDouble(Context c, int listItem, ArrayList<Order> data) {
        super(c, listItem, data);
        lInflater = LayoutInflater.from(c);
        this.data = data;
        ctx = c;

        tf = Typeface.createFromAsset(ctx.getAssets(), "meiryo.ttc");

        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().showStubImage(R.drawable.no_image).showImageForEmptyUri(R.drawable.no_image).cacheOnDisc().cacheInMemory().build();

        config = new ImageLoaderConfiguration.Builder(c.getApplicationContext()).threadPriority(Thread.NORM_PRIORITY - 2).memoryCacheSize(2 * 1024 * 1024)
                // 2 Mb
                .memoryCacheExtraOptions(100, 100).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO)
                .enableLogging().build();
        ImageLoader.getInstance().init(config);

        SharedPreferences sharedPref;

        sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);
        posters = sharedPref.getBoolean("poster", true);
        fixFont = sharedPref.getBoolean("fix_font", false);

        String width = sharedPref.getString("image_width", "70");
        imageWSize = Integer.parseInt(width); // ширина
        headerSize = Float.parseFloat(sharedPref.getString("headsize", "20"));
        timeSize = Float.parseFloat(sharedPref.getString("timesize", "15"));

        finaleColor = sharedPref.getString("finale_color", "1");
        chooseColor = sharedPref.getString("colorList", "");
        final_ep = ctx.getString(R.string.final_ep);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        o = data.get(position);

        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.double_list_item, null);
            holder = new ViewHolder();
            holder.textName = (TextView) convertView.findViewById(R.id.text);
            if (fixFont) {
                try {
                    holder.textName.setTypeface(tf);
                }
                catch (Exception e) {
                    Toast.makeText(ctx, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
            else {
                try {
                    holder.textName.setTypeface(Typeface.DEFAULT);
                }
                catch (Exception e) {
                    Toast.makeText(ctx, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
            holder.textEpisode = (TextView) convertView.findViewById(R.id.text2);
            holder.img = (ImageView) convertView.findViewById(R.id.image);


            final float scale = getContext().getResources().getDisplayMetrics().density;
            int px = (int) (imageWSize * scale + 0.5f);

            holder.img.getLayoutParams().height = LayoutParams.WRAP_CONTENT;
            holder.img.getLayoutParams().width = px;
            if (imageWSize == 0) {
                holder.img.getLayoutParams().width = LayoutParams.WRAP_CONTENT;
            }
            holder.img.setPadding(5, 5, 5, 5);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.textName.setTextSize(headerSize); // размер названия

        holder.textEpisode.setTextSize(timeSize); // размер времени

        if (posters) {
            holder.img.setVisibility(View.VISIBLE);
            try {
                imageLoader.displayImage(o.getLink(), holder.img, options);
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        else {
            holder.img.setVisibility(View.GONE);
        }

        holder.img.setTag(o);
        holder.textName.setText(o.getTextName());
        holder.textEpisode.setText(o.getTextEpisode());
        holder.textEpisode.setTextColor(Color.BLACK);


        if (o.getTextEpisode().toString().contains()) {

            if (finaleColor.contains("default")) {
                holder.textEpisode.setTextColor(Color.parseColor("#2E64FE"));
            }
            if (finaleColor.contains("yelow")) {
                holder.textEpisode.setTextColor(Color.YELLOW);
            }
            if (finaleColor.contains("red")) {
                holder.textEpisode.setTextColor(Color.RED);
            }
            if (finaleColor.contains("green")) {
                holder.textEpisode.setTextColor(Color.GREEN);
            }
            if (finaleColor.contains("white")) {
                holder.textEpisode.setTextColor(Color.WHITE);
            }
            if (finaleColor.contains("gray")) {
                holder.textEpisode.setTextColor(Color.GRAY);
            }
        }
        else {
            holder.textEpisode.setTextColor(Color.parseColor("#2E64FE"));
        }


        if (chooseColor.contains("white")) {
            int colorPos = position % colorWhite.length;
            convertView.setBackgroundColor(colorWhite[colorPos]);
        }
        if (chooseColor.contains("black")) {
            int colorPos = position % colorBlack.length;
            convertView.setBackgroundColor(colorBlack[colorPos]);
            holder.textName.setTextColor(Color.parseColor("#FFFFFF"));
        }
        if (chooseColor.contains("whitegray")) {
            int colorPos = position % colors.length;
            convertView.setBackgroundColor(colors[colorPos]);
        }
        if (chooseColor.contains("transparent")) {
            int colorPos = position % colorTransparent.length;
            convertView.setBackgroundColor(colorTransparent[colorPos]);
        }

        return convertView;
    }
}