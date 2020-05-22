checkBoxProva.setOnCheckedChangeListener(new new CompoundButton.OnCheckedChangeListener() {

       @Override
       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

            seekBarProva.setEnabled(isChecked);

       }
   }
);