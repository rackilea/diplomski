public boolean equals (Object object)
    {
        if (!(object instanceof Person || object == null)){
            return false 
        }
        Person per = (Person)object;
        if ((this.toString()).equals(per.toString()))
        {
           return true;
        }
        return false;
    }