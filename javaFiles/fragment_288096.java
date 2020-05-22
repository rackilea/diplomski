// Wrong
geoTester = lines[0];
if (geoTester == "success"){ //test the first returned line for success or failure to avoid null outputs in the panel


// Correct
if (geoTester.compareTo("success") == 0)