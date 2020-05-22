@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int currentCategory = mData.get(position).getImage();
        holder.categoriesButton.setImageResource(currentCategory);
        holder.vategoriesButton.setOnClickListener(...)
    }