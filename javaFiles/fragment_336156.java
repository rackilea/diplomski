@Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
           if (requestCode == groupRequestCode) { // here you come back from Group.java
                if(resultCode == RESULT_OK){
                    // do your stuff here
                    String textViewName = data.getStringExtra("GroupTag");
                    tvgroup.setText(textViewName);
                }
            }

           if (requestCode == statusRequestCode) { // here you come back from Status.java
                if(resultCode == RESULT_OK){
                    // do your stuff here
                    String status = data.getStringExtra("StatusTag");
                    tvstatus.setText(status);
                }
            }
        }