@Override
        public void onResponse(Call<List<Games>> call, Response<List<Games>> response) {
            if(response.isSuccessful()) {
                gameslist = response.body();
                adapter = new GameRecyclerViewAdapter(MainActivity.this, gameslist); 
                //change your Activity name here insted of MainActivity
                recyclerView.setAdapter(adapter);
            }
        }