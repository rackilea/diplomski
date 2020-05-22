@Override
public void onPostExecute(){
    GameList games;
    GameListPagerAdapter adapter = new GameListPagerAdapter(getFragmentManager(), games);    
    view_pager.setAdapter(adapter);
}