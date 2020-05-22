//Your other code

public static location [][] locMove() {  // <--- change void for location [][]
location [][] grid = new location[4][4]; 
        {
            grid [1][0] = new location("LABORATORY", 0, "You're in the lab.");
            grid [2][0] = new location("DUNGEON", 1, "You entered the dungeon.");
            grid [3][0] = new location("COURTYARD ENTRANCE",2,"You have left the dungeon out the backdoor. Either head east and search the courtyard maze, or travel north back to the dungeon");
            grid [3][1] = new location("FIRST PATH", 3,"You have now entered the courtyard, either continue east or move north.");
            grid [3][2] = new location("DEADEND", 4,"You have reached a deadend that has a Magic Shop. Go inside and explore it.");
            grid [3][3] = new location ("MAGIC SHOP", 5, "Search around the Magic Shop and see what there is. When you're done searching continue through the maze.");
            grid [2][1] = new location("SECOND PATH",6,"Search the surroundings for items that will help you get into the locked room, then keep moving.");
            grid [2][2] = new location("END MAZE", 7, "You've made it to the end of the courtyard. There seems to be a cave in the distance; go check it out.");
            grid [1][2] = new location("CAVE",8,"Explore the cave to find the remaining items that will lead to your freedom.");
            grid [0][0] = new location("EXIT",9,"This room will lead to your freedom, but you need the three essential items that will open this door.");
        }
    while (grid.equals(0)) {
        System.out.println(message.toString());
    }

 return grid;
 }

 //Your other code