@Override
    public int compareTo(StudentSet o)
    {
         int i = ((Integer) this.age).compareTo(o.age);
            if (i == 0)
                return this.name.compareTo(o.name);
            else
               return i;
    }