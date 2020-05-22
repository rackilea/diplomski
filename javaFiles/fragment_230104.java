//The sizes of BitSet used are all numbers that, when expressed in binary form,
//are all ones. This is to enable fast downsizing from one bitset to another
//by simply ANDing each set index in one bitset with the size of the target bitset
// - this provides a fast modulo of the number. Values previously accumulated in
// a large bitset and then mapped to a smaller set can be looked up using a single
// AND operation of the query term's hash rather than needing to perform a 2-step
// translation of the query term that mirrors the stored content's reprojections.
static final int usableBitSetSizes[];
static
{
  usableBitSetSizes=new int[30];
  int mask=1;
  int size=mask;
  for (int i = 0; i < usableBitSetSizes.length; i++) {
      size=(size<<1)|mask;
      usableBitSetSizes[i]=size;
  }    
}