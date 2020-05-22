public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
        {
            // get some data related to the selected item
            color_id = datalist1.get(i).getId();
            // attach it to the spinner
            adapterView.setTag(color_id);
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            // DO Nothing here
        }