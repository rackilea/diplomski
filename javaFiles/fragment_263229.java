public class Movie
{
    String name;
    int hour , min , screen;

    public Movie ( )
    {
        super ( );
    }


    public Movie ( String name , int hour , int min , int screen )
    {
        super ( );
        this.name = name;
        this.hour = hour;
        this.min = min;
        this.screen = screen;
    }



    public String getName ( )
    {
        return name;
    }

    public void setName ( String name )
    {
        this.name = name;
    }

    public int getHour ( )
    {
        return hour;
    }

    public void setHour ( int hour )
    {
        this.hour = hour;
    }

    public int getMin ( )
    {
        return min;
    }

    public void setMin ( int min )
    {
        this.min = min;
    }

    public int getScreen ( )
    {
        return screen;
    }

    public void setScreen ( int screen )
    {
        this.screen = screen;
    }

    @Override
    public String toString ( )
    {
        return "Movie [name="   + name + ", hour=" + hour + ", min=" + min + ", screen=" + screen
                + "]";
    }



}