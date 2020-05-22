if(holder.checkBox.isChecked()) {
     if(!positions.contains(position))
        positions.add(position);

 } else {
     if(positions.contains(position))
         positions.remove(position);

 }