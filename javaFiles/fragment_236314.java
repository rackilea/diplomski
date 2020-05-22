static NSCondition* g_dataLock = nil;

...

+ (void)initialize
{
    if (self == [MyClass class])
    {
        g_dataLock = [NSCondition new];
    }
}

+ (void)postData:(NSData*)data
{
    [g_dataLock lock];
    dataId++;
    [g_dataLock signal];
    [g_dataLock unlock];
}

+ (NSData*)getData
{
    NSData* data = nil;

    [g_dataLock lock];
    [g_dataLock wait];

    data = ...

    [g_dataLock unlock];

    return data;
}