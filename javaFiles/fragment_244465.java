chatRequestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              requestView = inflater.inflate(R.layout.send_request,null);
              alert.setView(requestView);

                alert.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        request = requestMsg.getText().toString();

                        send();

                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                alert.show();

            }
        });