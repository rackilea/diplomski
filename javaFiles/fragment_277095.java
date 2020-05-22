PrintWriter out = new PrintWriter(file);
BufferedReader in = new BufferedReader(new FileReader(original));
while (true)
{
    String line = in.nextLine();
    if (line == null)
        break;
    out.println(line);
}
out.close();