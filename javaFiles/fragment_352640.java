class Story
{
    void apply( Viewer viewer )
    {
      System.out.println( "Default implementation" )
    }
}

class News extends Story
{
  void apply( Viewer viewer )
  {
     viewer.setTextBody( this.title + " " + this.content );
  }
}

class Wheather extends Story
{
  void apply( Viewer viewer )
  {
     viewer.setTextBody( this.title + " " + this.temperature );
  }
}

code 

List< Story > list;

for( Story story : list )
{
  story.apply( this );
}