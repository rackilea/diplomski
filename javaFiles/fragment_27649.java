final frendsViewHolder finalHolder = holder;
  holder.btQ1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new UpdateAnswer(id, q1, finalHolder).execute();
    }
});