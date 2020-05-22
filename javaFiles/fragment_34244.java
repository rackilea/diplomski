public class Home
{
    Rooms r;

    public Home()
    {
        r = new Rooms();
    }

    public void getHomeDetails()
    {
        r.getRooms();
    }

    public class Rooms
    {

        public void getRooms()
        {
            System.out.println("20");
        }
    }
}

class BigHome extends Home
{
    public BigHome()
    {
        r = new Inner();
    }

    public class Inner extends Home.Rooms
    {

        public void getRooms()
        {
            System.out.println("100");
        }
    }
}