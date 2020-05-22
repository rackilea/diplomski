SpannableStringBuilder ssb = new SpannableStringBuilder();
    ssb.append(getString(R.string.hello));
    ssb.append(" ");
    ssb.append(" ");
    ssb.append(getString(R.string.world));

    // edited here , add length
    int length = getString(R.string.hello).length();

    Drawable d1 = ContextCompat.getDrawable(getContext(), R.drawable.ic_arrows_leftandright_black);
    d1.setBounds(0, 0, d1.getIntrinsicWidth(), d1.getIntrinsicHeight());
    ImageSpan span1 = new ImageSpan(d1, ImageSpan.ALIGN_BASELINE);

    // edited here , add length to it
    ssb.setSpan(span1, length, length + 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);