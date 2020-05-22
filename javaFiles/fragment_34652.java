/*
 * Data objects have an Object header followed by their instance data.
 */
struct DataObject : Object {
    /* variable #of u4 slots; u8 uses 2 slots */
    u4              instanceData[1];
};