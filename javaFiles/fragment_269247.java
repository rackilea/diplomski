@Override
protected void onStart() {
    super.onStart();
    adapter.startListening();
}

@Override
protected void onStop() {
    super.onStop();

    if (adapter != null) {
        adapter.stopListening();
    }
}