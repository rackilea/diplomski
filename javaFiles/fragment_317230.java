-(NSData *)getUnknownData:(Sample s){
   int length = s.data.count-index;
   NSMutableData *theData = [NSMutableData dataWithCapacity:length];

   theData.length = length;
   char *theBytes = (char *)theData.mutableBytes;
   for(int i = 0; i < length; ++i) {
       theBytes[i] = (char)[s.data[UNKNOWN_STATUS_INDEX + i] intValue]
   }
   return [theData copy];
}