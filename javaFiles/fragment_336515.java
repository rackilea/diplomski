java.util.Random random = new Random();
List<Integer> rectangles = new ArrayList<Integer>();
for(int i = 0; i < grid.length; i++)
{
  rectangles.add(i);
}
//Fill the rectangles
for(int i = 0; i < 32; i++)
{
  int position = random.nextInt(rectangles.size());
  Integer toConvert = rectangles.remove(position);
  //perform operation to make toConvert blue.
  grid[toConvert] = true;
}