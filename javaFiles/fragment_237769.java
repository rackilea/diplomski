@RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
  public void findPet(
        @MatrixVariable Map<String, String> matrixVars,
        @MatrixVariable(pathVar="petId") Map<String, String> petMatrixVars) {
    System.out.println(matrixVars);
     System.out.println(petMatrixVars);

  }
}