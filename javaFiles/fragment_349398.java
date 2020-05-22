public boolean addVehicle(Vehicle[] Honda) throws FileNotFoundException
{
    boolean found = false;
    int position = 0;
        if(canAddVehicle() == true)
        {
            for(int i = 0; i < vehicles.length && !found; i++)
            {
                if(vehicles[i] == null)
                {
                    position = i;
                    found = true;
                }
            }

               Scanner reader = new Scanner(file);
               while(reader.hasNext())
               {
                   Honda[position] = new Vehicle();
                   Honda[position].readRecord(reader);
                   vehicles[position] = Honda[position];
                   position++;

               }
                reader.close();
                return true;
        }
        return false;
}