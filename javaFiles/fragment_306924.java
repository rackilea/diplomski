next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(++j >= allQuestions.length){
                j = 0;
            }
            tv.setText(allQuestions[j]) ;               
        }
    }) ;