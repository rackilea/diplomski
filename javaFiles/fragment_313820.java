start.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.activity_dialog);
            dialog.setTitle("Choose");
            dialog.show();
            multi1 = dialog.findViewById(R.id.multi1);
            multi2 = dialog.findViewById(R.id.multi2);
            multi3 = dialog.findViewById(R.id.multi3);
            singleA = dialog.findViewById(R.id.singleA);
            singleB = dialog.findViewById(R.id.singleB);
            singleA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        multi1.setChecked(true);
                        multi2.setChecked(true);
                        multi3.setChecked(true);
                    }else{
                        multi1.setChecked(false);
                        multi2.setChecked(false);
                        multi3.setChecked(false);
                    }
                }
            });
            singleB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        multi1.setChecked(false);
                        multi2.setChecked(false);
                        multi3.setChecked(false);
                    }else{
                        multi1.setChecked(true);
                        multi2.setChecked(true);
                        multi3.setChecked(true);
                    }
                }
            });
        }

    });