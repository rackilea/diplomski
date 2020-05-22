class PeopleAdapter
        extends RealmRecyclerViewAdapter<Person, PeopleAdapter.PersonViewHolder> {
    private final String TAG = "PeopleAdapter" ;
    private final boolean DEBUG = true ;

    private PersonView.OnPersonClickListener onPersonClickListener ;

    static class PersonViewHolder extends RecyclerView.ViewHolder{
        PersonView personView ;
        PersonViewHolder(PersonView personView) {
            super(personView) ;
            this.personView = personView ;
        }
    } // end of PersonViewHolder class


    // Constructor
    PeopleAdapter(OrderedRealmCollection<Person> data) {
        super(data, true, true) ; // data, autoUpdate, updateOnModification
    }

    void setOnPersonClickListener(PersonView.OnPersonClickListener onPersonClickListener) {
        this.onPersonClickListener = onPersonClickListener ;
    }


    @Override
    public PeopleAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PersonView view = (PersonView) LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.item_view_person, parent, false) ;
        return new PersonViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personView.setOnPersonClickListener(onPersonClickListener) ;
        holder.personView.setUser(getData().get(position)) ;
    }
}