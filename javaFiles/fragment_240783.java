Spannable s = (Spannable) Html.fromHtml(foodString);
for (URLSpan u: s.getSpans(0, s.length(), URLSpan.class)) {
     s.setSpan(new UnderlineSpan() {
         public void updateDrawState(TextPaint tp) {
              //remove the underline
              tp.setUnderlineText(false);       
              //set text color            
              tp.setColor(getResources().getColor(R.color.orange));
          }
      }, s.getSpanStart(u), s.getSpanEnd(u), 0);
 }
 dinnerLabel.setText(s);
 dinnerLabel.setMovementMethod(LinkMovementMethod.getInstance());