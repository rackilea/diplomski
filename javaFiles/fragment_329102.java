public static void main(String args[])
{
  Room[][] maze;
  try {
    maze = Room.readRooms("C:/Users/Blaise/Programming/csc300/Maze");
  } catch (IOException e) {
    e.printStackTrace();
  }
}