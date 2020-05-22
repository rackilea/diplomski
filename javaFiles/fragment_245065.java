TextView signsAndSymptomsHeader;
ScrollView scrollView;

// do necessary initializations of Views, setup etc ...
// then the following in your onCreate method

signsAndSymptomsHeader.setOnClickListener(new View.OnClickListener(){
    @Override
    onClick(View v){
        switch (v.getId()){
             case R.id.id_of_signs_symptoms_content :
                 scrollView.scrollTo(0,v.getTop());
                 break;
             // repeat for all headers.
        }
    }
});