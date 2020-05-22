try {
   // code
}
catch (SpecificCheckedException sce) {
   // make sure there is exception logging done farther up
   throw new RuntimeException(sce);
}