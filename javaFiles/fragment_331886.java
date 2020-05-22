firstQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        List<UserModel> list = new ArrayList<>();
        if (task.isSuccessful()) {
            for (DocumentSnapshot document : task.getResult()) {
                UserModel userModel = document.toObject(UserModel.class);
                list.add(userModel);
            }

            secondQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot document : task.getResult()) {
                            UserModel userModel = document.toObject(UserModel.class);
                            list.add(userModel);
                        }

                        //Use the list of users
                    }
                }
            });
        }
    }
});