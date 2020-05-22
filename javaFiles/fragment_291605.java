int currentQueIndex=0; //member variable

next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           if(currentQueIndex<questionsList.size()){
              Question q:questionsList.get(currentQueIndex);//use q to render your layout
              currentQueIndex++;
           }
        }
    });