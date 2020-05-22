for (DataModel mo:data ) {
    this.List_FAVCurrentLocationLAT = mo.getFAVCurrentLocationLAT();
    this.List_FAVCurrentLocationLONG = mo.getFAVCurrentLocationLONG();
    Log.i("helloLAT",""+List_FAVCurrentLocationLAT); //OK
    Log.i("helloLONG",""+List_FAVCurrentLocationLONG); //OK
    // This section writes the favorite locations seperately to the log. 
}