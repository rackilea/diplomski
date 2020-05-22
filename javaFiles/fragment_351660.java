mRandombtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Do this if you do not want
        // numbers from last click
        marksixnum.clear();
        for (int j = 1; j <= 6; j++) {
            int random = (int) (Math.random()* 49+1);
            marksixnum.add(random);
            Collections.shuffle(marksixnum);
        }
        // add arrayAdapter to listview
        marksixlist.setAdapter(arrayAdapter);
    }
});