String str1 = "Hello";
            String str2 = "world";
            String message = str1 + " " + str2;

            Spannable spannable = new SpannableString(message);
            spannable.setSpan(new ForegroundColorSpan(Color.BLUE),0, str1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            textView.setText(spannable);