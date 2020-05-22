holder.productCodeView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        public void onFocusChange(View v, boolean hasFocus) {
            if(hasFocus) {
                currentFocusView = v;
            }

        }
    });

    holder.productCodeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {


            if (currentFocusView != null) {
                int iPosition = (Integer) currentFocusView.getTag();

            }


        }
    });