if(results.count==0)
{
 Toast.makeText(mcontext, "No results...", Toast.LENGTH_SHORT).show();
}

else
{

adapter.players= (ArrayList<Player>) results.values; 
adapter.notifyDataSetChanged();

}