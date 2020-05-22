@Override
     public void onBindViewHolder(ViewHolder holder, int position) {
         holder.text.setText(mResults.get(position));
         recyText.setText(recyText.getText()+ " " +mResults.get(position))

      }