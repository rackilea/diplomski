class parent ()
    {
        public boolean update()
        {
             if (this.count<0)
             {
                 return false;
             }
             // do parent stuff
             return true; 
        }
    }
    class child extends parent ()
    {
        @Override
        public boolean update()
        {
             if( super.update() )
             {
                 // do child stuff
             }
            return true;    


  }
}