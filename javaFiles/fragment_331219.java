lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            //You can find your button here
           if(view instanceof Button)
            {
                if(view.getId() == R.id.getenter)
                {
                    Toast.makeText(getApplicationContext(),"toast_msg",Toast.LENGTH_LONG).show();
                }
            }


        }
    });