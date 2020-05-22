private void displayFlowers(Flower flowerPack[])
    {       
        String[] usedNames = new String[flowerPack.length];
        int[] nameCounts = new int[flowerPack.length];
        int usedNamesCount = 0;

        for (int i = 0; i < flowerPack.length; i++) 
        {
            Flower flower = flowerPack[i];
            if (flower == null) 
            { 
                continue; 
            }                
            int nameIndex = -1;
            for (int j = 0; j < usedNamesCount; j++) 
            {
                String usedName = usedNames[j];                    
                if (flower.getFlowerName().equals(usedName)) 
                {
                    nameIndex = j;
                    break;
                }
            }                
            if (nameIndex != -1) 
            {
                nameCounts[nameIndex] += 1;
            } 
            else 
            {
                usedNames[usedNamesCount] = flower.getFlowerName();
                nameCounts[usedNamesCount] += 1;
                usedNamesCount++;
            }
        }            
        for (int i = 0; i < usedNamesCount; i++) 
        {
            System.out.println(usedNames[i] + "s - " + nameCounts[i]);
        }
    }