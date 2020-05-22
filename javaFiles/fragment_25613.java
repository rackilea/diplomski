@Override
protected void publishResults(CharSequence constraint, FilterResults results) {
    // Now we have to inform the adapter about the new list filtered       
    objectsF = (ArrayList<F>) results.values;
    notifyDataSetChanged();
}