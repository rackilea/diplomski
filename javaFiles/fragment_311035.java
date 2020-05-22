override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder).bind(getItem(position))

// For Filippo :)
holder.itemView.setBackgroundColor(Color.parseColor(MyClass.foo["a"]))
    }