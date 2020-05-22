while(packages.get(i)!=null)
    {
        if(packages.get(i).equals(z))
        {
            packages.remove(i);
            this.setNumPack(this.getNumPack()-1);
        } else {
            i++;
        }
    }