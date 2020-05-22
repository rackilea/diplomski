String txt = "partial colored #text";
        int to_len = txt.length();
        int sim_pos = txt.indexOf("#");

        SpannableString WordtoSpan = new SpannableString(txt);        
          WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), sim_pos, to_len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
          textView.setText(WordtoSpan);