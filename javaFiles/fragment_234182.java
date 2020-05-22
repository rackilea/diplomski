const int NR_ELEMENTS = 100;

NSMutableArray *objects = [NSMutableArray arrayWithCapacity:NR_ELEMENTS];

for (int i=0; i < NR_ELEMENTS; i++)
{
    MyClass *mc = [[MyClass alloc] initWith:i];
    [objects addObject:mc];
}

for (int i=0; i < NR_ELEMENTS; i++)
{
    // Suppose MyClass.value is integer
    NSLog(@"%i\n", [[objects objectAtIndex:i] value]);
}