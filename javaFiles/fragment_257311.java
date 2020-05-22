while((line = br.readLine()) != null)
{
    if(count == 0)
    {
       count++;
       continue;
    }
    players.add(br.readLine());
}