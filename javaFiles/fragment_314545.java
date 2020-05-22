final RelativeLayout rootLayout = (RelativeLayout)findViewById(R.id.myRootLayout);
    final Random random = new Random(3); //generates 0 to 2 (as you set seed of 3 digits starting from 0)

    final List<Integer> myBackgroundImages = new ArrayList<Integer>();
    myBackgroundImages.add(R.drawable.add_person);
    myBackgroundImages.add(R.drawable.add_photo_album);
    myBackgroundImages.add(R.drawable.add_key_box);


    rootLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rootLayout.setBackground(myBackgroundImages.get(random.nextInt()); //will be 0, 1, or 2
        }
    });