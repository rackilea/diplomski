public ResponseEntity<?> getArrayValues(@RequestBody List<TestTmpConverter> myJson ) {
    List<TestTmpConverter> test=myJson.getTest();
    List<TestTmpConverter> tmp=myJson.getTmp();

    // Do your work

}