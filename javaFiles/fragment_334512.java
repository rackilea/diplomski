@Test
  public void testCharacterEquals() {
    //primitive type uses == operator for equals comparasion
    char a1 = 'A';
    char a2 = 'A';
    if (a1 == a2) {
      System.out.println("primitive type comparasion: it's equal");
    }

    //From Java doc; The Character class wraps a value of the primitive type char in an object. An object of type Character contains a single field whose type is char.
    //Object type uses equals method for equals comparasion
    Character character1 = 'A';
    Character character2 = 'A';
    if (character1.equals(character2)) {
      System.out.println("object type comparasion: it's equal");
    }
  }