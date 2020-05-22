if (rowView == null) {
   // init view, holder
   rowView.setTag(holder)
} else {
   holder = (Holder) rowView.getTag();
}

// fill data