@Override
public Query getQuery(DatabaseReference databaseReference) {
    // All my posts order by category

    Intent intent=getActivity().getIntent();

    mPostKey = intent.getStringExtra(EXTRA_CATEGORYV);

    Query viewCategory = databaseReference.getDatabase().getReference("posts");
    return viewCategory.orderByChild("category").equalTo(mPostKey);
}