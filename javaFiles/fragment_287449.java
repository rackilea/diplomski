MIB_IFTABLE ifTable = new MIB_IFTABLE();
IntByReference psize = new IntByReference(ifTable.size());
int status = ipHlpApi.GetIfTable(ifTable, psize, false);
if (status == 122) {
    // Calculate the required number of elements in the MIB_IFROW array
    ifTable = new MIB_IFTABLE((psize.getValue() - 4) / ifTable.table[0].size());
    psize.setValue(ifTable.size());
    status = ipHlpApi.GetIfTable(ifTable, psize, false);
    // If status is still 122, then there's an issue with the MIB_IFROW definition
    // ...
}