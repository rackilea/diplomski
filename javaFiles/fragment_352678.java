deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myPasswordDialog mPasswordDialog = new MyPasswordDialog(new MyPasswordDialog() {
                        @Override
                        public void onResult(boolean result) {
                        // result will be your ans
                        }
                    });
                    mPasswordDialog.show(getFragmentManager(), "delete");
                }
            });