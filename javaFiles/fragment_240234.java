else if (response.body().getAsJsonArray().size()==0) 
               {
                Toast.makeText(getContext(), "No Data to display.", Toast.LENGTH_LONG).show();
                if (pDialog.isShowing()) {
                    pDialog.dismiss();
                }