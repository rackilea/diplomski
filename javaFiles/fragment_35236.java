TextView txt = (TextView) findViewById(R.id.custom_fonts);  
        txt.setTextSize(30);
        Typeface font = Typeface.createFromAsset(getAssets(), "Akshar.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "bangla.ttf");   
        SpannableStringBuilder SS = new SpannableStringBuilder("আমারநல்வரவு");
        SS.setSpan (new CustomTypefaceSpan("", font2), 0, 4,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        SS.setSpan (new CustomTypefaceSpan("", font), 4, 11,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        txt.setText(SS);