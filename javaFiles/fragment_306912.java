public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        View one = layoutInflater.inflate(R.layout.slide_type_a, container, false);


        WebView header_1_a = (WebView) one.findViewById(R.id.header_slide_type_a_1);
        loadHTLMContentHeader(getString(R.string.Historie1_header),header_1_a);

        ImageView image_1_a = (ImageView) one.findViewById(R.id.image_slide_type_a_1);
        image_1_a.setImageResource(R.drawable.picture_kap01_01);
        WebView text_1_a = (WebView) one.findViewById(R.id.text_slide_type_a_1);
        loadHTLMContentText(getString(R.string.Historie1), text_1_a);


        View two = layoutInflater.inflate(R.layout.slide_type_a, container, false);

        View three = layoutInflater.inflate(R.layout.slide_type_a, container, false);
        View four = layoutInflater.inflate(R.layout.slide_type_b, container, false);

        View five = layoutInflater.inflate(R.layout.slide_type_b, container, false);

        View six = layoutInflater.inflate(R.layout.slide_type_b, container, false);

        View seven = layoutInflater.inflate(R.layout.slide_type_b, container, false);

        View eight = layoutInflater.inflate(R.layout.startquiz_layout, container, false);
        View viewarr[] = {one, two, three, four, five, six, seven, eight};
        container.addView(viewarr[position]);


        return viewarr[position];

    }