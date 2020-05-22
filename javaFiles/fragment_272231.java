@NonNull
    @Override
    public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate( R.layout.list_item_crime, viewGroup, false );
        // here pass view as a constructor 
        return new CrimeHolder(view);
    }