unsigned char *fromBinary(const char * const s)
{
   static unsigned char toReturn[8]={0};
   size_t i,j;
   const size_t len=8;

   for(i=0;i<len;i++)
       {
       toReturn[i]=0;
       for(j=0;j<8;j++)
          toReturn[i]|=(s[i*8+j]=='1' ? 1<<(7-j) : 0);
       }
   return toReturn;
}