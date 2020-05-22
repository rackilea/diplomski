TableLayout tl = (TableLayout) findViewById(R.id.feeds_table);
    tl.setColumnStretchable( 1, true ); // this line fix the error

      for(int i=0 ; i < 10 ; i++) {
     /*create a linear layout to user picture*/
        LinearLayout linearUserPicture = new LinearLayout(this);
        linearUserPicture.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wlienar, hlienar);

        layoutParams.setMargins(0, 0, margim, 0);

        RoundedImageView imageView = new RoundedImageView(this, null);
        imageView.setImageResource(R.mipmap.eu);

        //setting image position
        imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(wUserPicture, hUserPicture));

        linearUserPicture.addView(imageView, layoutParams);

        /*create a linear layout to user comments beer*/

        //user name
        TextView textViewUserName = new TextView(this);
        if (Build.VERSION.SDK_INT < 23) {
            textViewUserName.setTextAppearance(this, R.style.feeds_user_connected_style);
        } else {
            textViewUserName.setTextAppearance(R.style.feeds_user_connected_style);
        }
        textViewUserName.setText(R.string.user_feed_name);

        // beer in date
        TextView textViewDateBeerIn = new TextView(this);
        if (Build.VERSION.SDK_INT < 23) {
            textViewDateBeerIn.setTextAppearance(this, R.style.dateBeeinAndPlace);
        } else {
            textViewDateBeerIn.setTextAppearance(R.style.dateBeeinAndPlace);
        }
        textViewDateBeerIn.setText(R.string.date_beerin);

        // textview beer
        TextView textViewBeer = new TextView(this);
        if (Build.VERSION.SDK_INT < 23) {
            textViewBeer.setTextAppearance(this, R.style.beerBeerin);
        } else {
            textViewBeer.setTextAppearance(R.style.beerBeerin);
        }
        textViewBeer.setText(R.string.beerBeerin);

        //textview place beer in
        TextView textViewPlace = new TextView(this);
        if (Build.VERSION.SDK_INT < 23) {
            textViewPlace.setTextAppearance(this, R.style.dateBeeinAndPlace);
        } else {
            textViewPlace.setTextAppearance(R.style.dateBeeinAndPlace);
        }
        textViewPlace.setText(R.string.place_beerin);

        //textview place count comments
        TextView textViewCountComments = new TextView(this);
        if (Build.VERSION.SDK_INT < 23) {
            textViewCountComments.setTextAppearance(this, R.style.countBeerinComment);
        } else {
            textViewCountComments.setTextAppearance(R.style.countBeerinComment);
        }
        textViewCountComments.setText(R.string.countBeerinComment);

        //adicionado os camponentes no linear que irá ajuntar todos no linear principal
        LinearLayout lienarComponents = new LinearLayout(this);
        lienarComponents.setOrientation(LinearLayout.VERTICAL);

        lienarComponents.addView(textViewUserName);
        lienarComponents.addView(textViewDateBeerIn);
        lienarComponents.addView(textViewBeer);
        lienarComponents.addView(textViewPlace);
        lienarComponents.addView(textViewCountComments);

        LinearLayout linearUserDataBeer = new LinearLayout(this);
        linearUserDataBeer.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParamsUserDataBeer = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, hLienarUserDataBeer);
        linearUserDataBeer.addView(lienarComponents, layoutParamsUserDataBeer);

        //logo beer

        /*create a linear layout to logo beer*/
        LinearLayout linearLogoBeer = new LinearLayout(this);
        linearLogoBeer.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams layoutParamsLogo = new LinearLayout.LayoutParams(wlienar, hlienar);

        //ImageView Setup
        ImageView imageViewLogoBeer = new ImageView(this);


        imageViewLogoBeer.setLayoutParams(
                new ViewGroup.LayoutParams(
                        // or ViewGroup.LayoutParams.WRAP_CONTENT
                        wLogoBeer,
                        // or ViewGroup.LayoutParams.WRAP_CONTENT,
                        hLogoBeer));

        imageViewLogoBeer.setImageResource(R.mipmap.beerin);

        linearLogoBeer.addView(imageViewLogoBeer, layoutParamsLogo);

        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tr.setBackgroundResource(R.drawable.border);

        tr.addView(linearUserPicture);
        tr.addView(linearUserDataBeer);
        tr.addView(linearLogoBeer);
        tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));

    }