Button  availableText = (Button)findViewById(R.id.request); 
            Spannable span =Spannable.Factory.getInstance().newSpannable(availableText.getText());
            span.setSpan(new AlignmentSpan.Standard(Alignment.ALIGN_NORMAL),0, 7, 
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); 
            span.setSpan(new AlignmentSpan.Standard(Alignment.ALIGN_OPPOSITE),8, 
            span.length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); 
            availableText.setText(span);