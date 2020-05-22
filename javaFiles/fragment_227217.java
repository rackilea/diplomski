HashSet<String> hs = new HashSet<String>();
int i = 0;
while ((line = br.readLine()) != null)
{
    i++;
       if (i % 4 == 0)
       {
          if(hs.contains(line))
             //name already exist
          else
            hs.add(line);
            // new customer do what you want with it

       }
}