class For extends Seq{
  public For( int first, int last, int step )
   {
     a=first;
     b=last;
     c=step;
   }
 @Override
 public String toString(){
    return "your parameters: "+ a + ", "+ b+ ", "+c;
 }
}