// Correct - eq() is also an argument matcher
    verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));


    // Incorrect - exception will be thrown because third argument is given without argument matcher.
    verify(mock).someMethod(anyInt(), anyString(), "third argument");