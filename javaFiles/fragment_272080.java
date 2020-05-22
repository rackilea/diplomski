Call<Buzz> buzz1 = buzz_service.buzz_API("Apple");
    buzz1.enqueue(new Callback<Buzz>() {
    @Override
    public void onResponse(Call<Buzz> call, Response<Buzz> response) {
        String buzz_1 = response.body().getBuzz();    //buzz_1="Apple"
        buzzArrayList.add(new Exchange(buzz_1));
        buzzAdapter.notifyDataSetChanged();

        Call<Buzz> buzz2 = buzz_service.buzz_API("Banana");
        buzz2.enqueue(new Callback<Buzz>() {
        @Override
        public void onResponse(Call<Buzz> call, Response<Buzz> response) {
            String buzz_2 = response.body().getBuzz();    //buzz_2="Banana"
            buzzArrayList.add(new Exchange(buzz_2));
            buzzAdapter.notifyDataSetChanged();

            Call<Buzz> buzz2 = buzz_service.buzz_API("Rice");
            buzz2.enqueue(new Callback<Buzz>() {
            @Override
            public void onResponse(Call<Buzz> call, Response<Buzz> response) {
                String buzz_3 = response.body().getBuzz();    //buzz_3="Rice"
                buzzArrayList.add(new Exchange(buzz_3));
                buzzAdapter.notifyDataSetChanged();
           }});
        }});
    }});