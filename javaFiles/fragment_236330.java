[StoreStore|LoadStore]
int x = 4; // volatile store of a shared "x" variable

int y = 3; // non-volatile store of shared variable "y"

int z = x; // volatile load
[LoadLoad|LoadStore]