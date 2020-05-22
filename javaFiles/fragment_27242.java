@Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (adapter == null) {
                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        Users_get post = childSnapshot.getValue(Users_get.class);
                        array_data.add(new Users_get(post.getName(), post.getSurname(), post.getPrice(), childSnapshot.getKey()));
                        getTotalPrice(post.getPrice());
                    }
                    setAdapter();
                } else {
                    adapter.notifyDataSetChanged();
                }
            }