@Override
public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) { 
      User user=dataSnapshot.getValue(User.class);
      user.setUid(dataSnapshot.getKey());
      int index = mDataList.indexOf(user);
      mDataList.remove(index);
      mUserAdapter.notifyDataSetChanged();
    }