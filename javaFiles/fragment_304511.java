int[] array = new int[size];
Node root = ...
int bytesWritten = FlattenTreeIntoArray(root, array, 0);

//bytesWritten should equal size
assert(bytesWritten == size);