class RvTestAdapter(val context: Context, val recyclerViewHeight: Int): RecyclerView.Adapter<TestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TestViewHolder(LayoutInflater.from(context).inflate(R.layout.vh_test, parent, false))

    override fun getItemCount() = 3

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        if (position == 2) { //last position
            holder.itemView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (holder.itemView.y + holder.itemView.height  > recyclerViewHeight) {
                        Log.d("YESSSS", "WOOP WOOP")
                    }

                    holder.itemView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }

            })
        }
    }

}