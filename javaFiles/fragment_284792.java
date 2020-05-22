Container(BorderLayout)
{
  @NORTH
    Container(BorderLayout)
    {
       @NORTH
         Label(Instruction);
       @CENTER
         Container(GridLayout(2,1))
         {
            Container(GirdLayout(2,2))
            {
              Label() TextField()
              Label() TextField() 
            }
            Container(GirdLayout(2,2))
            {
              Label() TextField()
              Label() TextField()
            }
         }
       @SOUTH
         Container(FlowLayout())
         {
           JButton() //shaded thing?
         }
    }
  @CENTER
    {
      JTable
    }
}