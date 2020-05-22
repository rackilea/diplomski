Here’s how it would look with map literals:


    final Map<Integer, String> platonicSolids = { 
          4 : "tetrahedron",
          6 : "cube", 
          8 : "octahedron", 
          12 : "dodecahedron", 
          20 : "icosahedron"
    };


Here is the empty map literal, which has a slightly irregular syntax to make
it differ from the empty set:


    Map<String, Integer> noJokeHere = { : };