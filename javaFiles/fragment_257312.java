while((line = br.readLine()) != null)
{
    if(count == 0)
    {
       count++;
       continue;
    }
    players.add(line); //The important change is here.
}