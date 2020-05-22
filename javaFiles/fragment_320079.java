@Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    switch (buttonView.getId()){
        case R.id.mondayButton:

            if(isChecked == true) {
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
            } else{
                    Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show();
                   }

            break;
         }

      }