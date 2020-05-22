Task<Uri> task = taskSnapshot.getMetadata().getReference().getDownloadUrl();
            task.addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String generatedFilePath = uri.toString();
                    imgpath.setText(generatedFilePath);





            ConnectDatabase db = new ConnectDatabase();
            Connection con = db.ConnectDB();
            if (con == null)
                Toast.makeText(getActivity(), "Please check your internet connection!", Toast.LENGTH_LONG).show();

            else {
                try {
                    Statement sm = con.createStatement();
                    int x = sm.executeUpdate("insert into CarBrand values('" + brandname.getText() + "','" + imgpath.getText() + "')");

                    if (x == 0)
                        Toast.makeText(getActivity(), "an error occurred, please try again in a few moments.", Toast.LENGTH_LONG).show();
                    else {
                        Toast.makeText(getActivity(), "Brand has been added.", Toast.LENGTH_LONG).show();
                        brandname.getText().clear();
                         }
                } catch (SQLException e) {
                    if (e.getErrorCode() == 2627)
                        Toast.makeText(getActivity(), "Brand already exists!", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getActivity(), "an error occurred", Toast.LENGTH_LONG).show();
                }

            }
                }
            });