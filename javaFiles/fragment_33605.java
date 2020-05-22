plus_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                model.addToGname("jignesh");
                model.addToGmember("8");

                adapter.addItem(model);
            }
        });