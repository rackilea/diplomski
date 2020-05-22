button_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Connect client to car
                String ip = editText_ip.getText().toString();
                String port = editText_port.getText().toString();
                if (ip.equals(server_ip) && port.equals(server_port)) {
                    ArrayMap<String, Object> putParams = new ArrayMap<>();
                    putParams.put("direction", 24); //Test server
                    Log.d(Test, "Test=" + Test);    //Test Log
                    RestClientHelper.getInstance().put(base_url, putParams, new RestClientHelper.RestClientListener() {
                        @Override
                        public void onSuccess(String response) {
                            //Connecting successful
                        }

                        @Override
                        public void onError(String error) {
                            // Connecting failed
                        }
                    });
                }
            }
        });