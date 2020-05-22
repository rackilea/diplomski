Scanner s = new Scanner(new File("coords.txt"));
int x = 0;
int y = 0;
if (s.hasNext())
    x = s.nextInt();
if (s.hasNext())
    y = s.nextInt();
s.close();