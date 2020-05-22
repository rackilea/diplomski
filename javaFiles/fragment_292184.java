adapter = new ArrayAdapter<String>(ActivityName.this,
            R.layout.custom_spinner, gender_arraylist) {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);


            return v;
        }

        public View getDropDownView(int position, View convertView,
                ViewGroup parent) {
            View v = super.getDropDownView(position, convertView, parent);
            //change height and width or text size and colour here

            return v;
        }
    };