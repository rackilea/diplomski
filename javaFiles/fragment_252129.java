public class AdventureBuilder
{
    private StoryRoom entryway;

    // Avoid naming a method 'main' unless it's the main method of your main class
    // Try something like 'initAdventureBuilder()' instead
    public void main()
    {
        // StoryRoom[] book = new StoryRoom[20];
        String[] description = null;
        description = new String[3];
        int[] exits;
        exits = new int[3];

        description[0] = "This is a strange room with 2 doors, one on the left and one on the right.";
        description[1] = "Take the left door? (enter 1)";
        description[2] = "Take the right door? (enter 2)";

        exits[0] = 1; // current room number
        exits[1] = 2;
        exits[2] = 3;

        entryway = new StoryRoom(description, exits);
    }

    // A way for AdventureBuilder to be questioned about its entryway field

    public StoryRoom getStoryRoom()
    {
        return entryway;
    }
}

public class AdventureTeller
{
    public static void main(String[] args)
    {
        // Creating a copy of AdventureBuilder that AdventureTeller knows about
        AdventureBuilder ab = new AdventureBuilder();
        StoryRoom entryway;

        // Asking AdventureBuilder to run itself 
        ab.main();

        // Asking AdventureBuilder for a reference to the entryway which it created
        // when you asked AdventureBuilder to run itself

        entryway = ab.getStoryRoom();

        for (int i = 0; i < entryway.description.length; i++)
        {
            System.out.println(entryway.GetDescription(i));
        }
    }
}