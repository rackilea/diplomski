Log.v("View.VISIBLE", ""+View.VISIBLE);      //0

        Log.v("View.GONE", ""+View.GONE);            //8

        Log.v("visible", ""+paragraphmore.getVisibility());

        if(paragraphmore.getVisibility() == 0){
            paragraphmore.setVisibility(View.VISIBLE);
            view.setText("Read Less");
        }else{
            paragraphmore.setVisibility(View.GONE);
            view.setText("Read More");
        }