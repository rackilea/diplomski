for (int i = 0; i < packages.size(); i++)
    {
        if(packages.get(i).equals(z))
        {
            packages.remove(i);
            this.setNumPack(this.getNumPack()-1);
            i--;
        }
    }