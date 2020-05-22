else if (i == 1) {
            rootView = inflater.inflate(R.layout.fragment_articles, container, false);
            listview1 = (ListView) rootView.findViewById(R.id.article_list);

            PostController postActivity = new PostController(mListener);
            postActivity.execute();               

        }