public class variationAdapter extends RecyclerView.Adapter<variationHolder> {

    public List<variationModel> ListOf;
    private UpdateTextCallback  updateTextCallback ;

    public variationAdapter(List<variationModel> listOf, UpdateTextCallback  updateTextCallback) {
        ListOf = listOf;
        this.updateTextCallback = updateTextCallback; 
    }
    ...
    ..
    .

    @Override
    public void onBindViewHolder(@NonNull variationHolder holder, int position) {
        holder.name.setText(ListOf.get(position).getName());

        horizontalAdapter adapter = new horizontalAdapter(this.ListOf.get(position).getData(), updateTextCallback);
        holder.horizontal_variation.setAdapter(adapter);

        System.out.println("Rohit" + ListOf.get(position).getName());
    }
    ...
    ..
    .
}