struct emxArray_real32_T
{
    int allocatedSize; // actually 'data'
    boolean_T canFreeData; // actually 'size'
    float *data; // actually 'allocatedSize'
    int numDimensions; 
    int *size; // actually 'canFreeData'
};