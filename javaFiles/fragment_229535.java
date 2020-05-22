@Override
public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
    Card card = cards.get(i);
    List<Set> sets = card.getSet();
    int x = sets.size();
    int count = 0;

    for(Set set : sets) {
        if(count == 0) {
            contactViewHolder.vName.setText(set.getName());
            contactViewHolder.vReps.setText(set.getReps() + "");
            contactViewHolder.vWeight.setText(set.getWeight() + "");
        } if(count == 1) {
            contactViewHolder.vReps1.setText(set.getReps() + "");
            contactViewHolder.vWeight1.setText(set.getWeight() + "");
        } if(count == 2) {
            contactViewHolder.vReps2.setText(set.getReps() + "");
            contactViewHolder.vWeight2.setText(set.getWeight() + "");
        } if(count == 3) {
            contactViewHolder.vReps3.setText(set.getReps() + "");
            contactViewHolder.vWeight3.setText(set.getWeight() + "");
        } if(count == 4) {
            contactViewHolder.vReps4.setText(set.getReps() + "");
            contactViewHolder.vWeight4.setText(set.getWeight() + "");
        } if(x > 4) {
            contactViewHolder.vShowMore.setText((x - 5) + " More");
        }
        count++;
    }


}