final boolean isExpanded = position == mExpandedPosition;
holder.mExpansion.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
holder.itemView.setActivated(isExpanded);
if (isExpanded) mPreviousExpandedPosition = holder.getAdapterPosition();
holder.itemView.setOnClickListener(v -> {
    mExpandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
    notifyItemChanged(mPreviousExpandedPosition);
    notifyItemChanged(holder.getAdapterPosition());
});