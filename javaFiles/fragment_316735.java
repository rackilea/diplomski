public int compareWith(Choice anotherChoice)
{
   if (this.type == anotherChoice.getType())
        return 0;
   return -1;
}