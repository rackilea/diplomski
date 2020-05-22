BufferedReader r = new BufferedReader(new FileReader(file));
for (int i = 0; i < lineNumber - 1; i++)
{
   r.readLine();
}
return r.readLine();