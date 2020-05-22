class MainAdapter(val feed: Array<Feed>): RecyclerView.Adapter<CustomViewHolder>(){

    override fun getItemCount(): Int {
        return feed.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowCell = layoutInflater.inflate(R.layout.repo_row, parent, false)
        return CustomViewHolder(rowCell)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val fd = feed.get(position)
        holder.view.titleText.text = fd.name.toString()
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}