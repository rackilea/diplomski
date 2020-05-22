class ListAdapter(
        private val _items: List<Any>,
        private val _context: Context
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return if (viewType == R.layout.item_standard) {
            StandardViewHolder(LayoutInflater.from(_context).inflate(
                    R.layout.item_standard, parent, false))
        } else {
            AdvancedViewHolder(LayoutInflater.from(_context).inflate(
                    R.layout.item_advanced, parent, false))
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder as BaseViewHolder<Any>).bind(_items[position])
    }

    override fun getItemCount() = _items.size

    override fun getItemViewType(position: Int): Int {
        return if (_items[position] is Standard) {
            R.layout.item_standard
        } else {
            R.layout.item_advanced
        }
    }
}