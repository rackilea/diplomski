int data_size;
int union_size = 16;
CUdeviceptr d_array;
// copying this to the device will not result in what you expect with out over allocating
// if you just copy over integers, which occupy 4 bytes each, your integers will fill less space than the number of unions 
//  we need to make sure that there is a "stride" here if we want to actually copy real data from host to device. 
// union_size / Sizeof.INT = 4, so there will be 4 x as many ints, 4 for each union. 
int[] h_array = new int[data_size * (union_size / Sizeof.INT)];


// here we aren't looking for size of int to allocate, but the size of our union. 
cuMemAlloc(d_array, data_size * union_size);
// we are copying, again, data_size * union_size bytes
cuMemcpyHtoD(d_array, Pointer.to(h_array), data_size * union_size);