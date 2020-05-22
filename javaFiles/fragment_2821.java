tx_submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        for (int i=0;i<chatFriendsListModels.size();i++){
            if(chatFriendsListModels.isChecked()==true)
           String id = chatFriendsListModels.get(i).getId();
            // you do what you want with id here
        }


    }
});