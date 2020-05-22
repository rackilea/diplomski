public Class Space
{    
    public interface Builder
    {
        public Space build();
        public int x();
        public int y();
        public int z();
    }

    // Build a complete Space object accounting for every field. 
    public Space(Space.Builder spaceBuilder)
    {
        this.x = spaceBuilder.x();
        this.y = spaceBuilder.y();
        this.z = spaceBuilder.z();
        this.time = builder.time();
    }

    // Might not be necessar if you update time when you update x, y, and z
     public Builder time(long val)
     {
            time = val;
            return this;
     }

     public void move()
     {
        // ...
     }

    public static void main(String[] args)
    {
        new Builder()
        {   
            @Override
            public Space build(){ return new Space(this);}

            @Override
            public int x(){ return 1;}

            @Override
            public int y{ return 1;}

            @Override int z{ return -1;}
        }.build().time(1234).move();
    }
}