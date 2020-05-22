ArrayList<News> newsList = new ArrayList<News>();
for( Element child : news ) {
  News news = new News();
  news.setTitle( child.getChildText( "title" );
  news.setDescription( child.getChildText( "description" );
  newsList.add( news );
}