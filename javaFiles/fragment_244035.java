-(MyObject*) getSharedObject
{
@synchronized(something)
{
     if(!singleton)
     {
          singleton = [[MyObject alloc] init];
     }
     return singleton;
}
}