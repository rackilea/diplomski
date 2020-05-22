bt.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            String details = "";
            GetPNR pnrDetails = new GetPNR();
            try {
                details = pnrDetails.execute(URI+et.getText().toString()).get();


                    Log.d("train", details);
                    tv.setText(details);


            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });