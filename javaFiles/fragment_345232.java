@Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                boolean success = mGoogleMap.setMapStyle(new MapStyleOptions(getResources()
                        .getString(R.string.style_json)));

                if (!success) {
                    Log.e("TabFragmentMap", "Style parsing failed.");
                }
            }else{
                boolean success = mGoogleMap.setMapStyle(null);

                if (!success) {
                    Log.e("TabFragmentMap", "Removing style failed.");
                }
            }
        }