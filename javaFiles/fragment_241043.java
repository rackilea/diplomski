public HistoryViewHolder(View itemView) {
    super(itemView);
    //This line is important
    ButterKnife.inject(this,itemView);

}