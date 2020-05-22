File file = new File(filepath);
BufferedReader br = new BufferedReader(file.getInputStream);
int n = Integer.parseInt(br.readLine());

for (int i = 0; i < n-1; i++) // reads n-1 points, if you have n points to read, use n instead of "n-1"
{
    line = br.readLine();
    StringTokenizer t = new StringTokenizer(line, " ");

    int x = Integer.parseInt(t.nextToken());
    int y = Integer.parseInt(t.nextToken());

    // do whatever with the points
}