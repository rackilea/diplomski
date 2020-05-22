class ViewHolder extends RecyclerView.ViewHolder{
    Button seeAnswer;
    ...

    ViewHolder(View itemView) {
        super(itemView);

        seeAnswer = (Button) itemView.findViewById(R.id.btnSeeAnswer);

        seeAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAnswer.setVisibility(View.GONE);
                hideButtons.put(getAdapterPosition(), true);
            }
        });

        ...
    }

}