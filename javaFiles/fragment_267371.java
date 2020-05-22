@Override
protected void onStart() {
  super.onStart();
FirebaseUser mCurrentuser = mAuth.getCurrentUser();
if (mCurrentuser == null) {
    sendTologin();
}
myadapter = new FirestoreRecyclerAdapter<Pharmacien, PharmacieViewHolder>(options) {
 @NonNull
    @Override
    public PharmacieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listlayout, parent, false);
        return new PharmacieViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull PharmacieViewHolder holder, int position, @NonNull Pharmacien model) {
        holder.setName(model.getNomSiege());
        holder.setAdresse(model.getAdressePH());
        holder.setDistance(String.valueOf(model.getPosition().getLatitude()));
        holder.setUserImage(model.getImageURL(), getApplicationContext());

        //to get key



        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

  };
 pharmacienlist.setAdapter(myadapter);
 myadapter.startListening();

  }
}