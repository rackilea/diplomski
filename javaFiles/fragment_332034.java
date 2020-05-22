cbSelectedCar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
            boolean isChecked) {
              if (isChecked){
                    caller.updateClickedUsername(currentJson, true); // Add to the List
                    Log.d("Added click ", "ok");
                }

                else if (!isChecked) {
                    caller.updateClickedUsername(currentJson, false); // Delete from the List
                    Log.d("Deleted click ", "nok");
                }

        }
      });