public class ReactiveAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    String[] mDataset = { "Data", "In", "Adapter" };

    private final PublishSubject<String> onClickSubject = PublishSubject.create();

    @Override 
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final String element = mDataset[position];

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onClickSubject.onNext(element);
            }
        });
    }

    public Observable<String> getPositionClicks(){
        return onClickSubject.asObservable();
    }
}