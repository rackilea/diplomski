btnOdustani.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

                 AsyncCallWS task = new AsyncCallWS();
            try {
               String pera= task.execute().get();
                Toast.makeText(Podesavanja.this,pera,Toast.LENGTH_LONG).show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


    });