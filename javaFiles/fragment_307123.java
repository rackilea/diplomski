@Override
            public void onClick(View v) {
                // add this!!!

                chatMsg = chatBoxText.getText().toString();


                try {
                    dataOutputStream.writeUTF(chatMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(ServerActivity.this, "An exception occurred: " + e.toString(), Toast.LENGTH_SHORT).show();
                    // TODO Auto-generated catch block

                }

            }