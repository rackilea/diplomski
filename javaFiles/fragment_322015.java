public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
   /// origin code here

  // reset data in adapter and not re-creating adapter:
  userAdapter.setItems(mUsers);
  getActivity().runOnUiThread(() -> userAdapter.notifyDataSetChanged());
 // instead of userAdapter= new UserAdapter(getContext(), mUsers, true); recyclerView.setAdapter(userAdapter); 
}