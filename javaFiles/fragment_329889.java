@Override
public void onBindViewHolder(ViewHolder viewHolder, int position) {

    GruposCardView gruposCardView = gruposCardViews.get(position);

    CreateAnimationView.createAnimationRandom(viewHolder.cardView);
   ...}