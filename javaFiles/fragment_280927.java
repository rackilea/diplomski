Del.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

         // HERE I WANT REFRESH MY LISTVIEW
         MainActivity.ArrayProdotto.remove(position); //Delete from main source
         rowItem.remove(position) // Delete from adapter
         CustomAdapter.ShowDialog("Elemento eliminato con successo!", context);
         notifyDataSetChanged(); // Refresh Adapter

    }
});