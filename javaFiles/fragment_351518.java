int pos -1;// default is -1, which means no one has altered it
// replicate this onclick listener logic
minuteText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(pos != -1){ // it is not -1 that means some1 has altered it                 
                parentView.findViewById(pos).
                      setBackground(new ColorDrawable(Color.TRANSPARENT));
            // the above line searched for the view and changed the background
            }
            pos = v.getId(); // the id of the new view, keep doing it
            v.setBackgroundResource(R.drawable.border);
        }
    });