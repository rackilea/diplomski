public int compareWith(Choice anotherChoice)
{
   Choice choice1 = new Choice(0);
   Choice choice2 = new Choice(1);
   if ((this.type == 0)&&(anotherChoice.getType() == 1)){
        return -1;