import java.util.Arrays;

// Add all your node names to an array
String[] nameLookup = new String[4];
nameLookup[0] = "A";
nameLookup[1] = "B";
nameLookup[2] = "C";
nameLookup[3] = "D";

// Our array is already properly sorted,
// but yours might not be, so you should sort it.
// (if it's not sorted then binarySearch won't work)
Arrays.sort(nameLookup);

// I'm assuming your edges are unweighted, so I use boolean.
// If you have weighted edges you should use int or double.
// true => connected, false => not connected
// (entries in boolean arrays default to false)
boolean[][] matrix = new boolean[4];
for (int i=0; i<matrix.length; i++) matrix[i] = new boolean[4];

// I don't want to call Arrays.binarySearch every time I want an index,
// so I'm going to cache the indices here in some named variables.
int nodeA = Arrays.binarySearch(nameLookup, "A");
int nodeB = Arrays.binarySearch(nameLookup, "B");
int nodeC = Arrays.binarySearch(nameLookup, "C");
int nodeD = Arrays.binarySearch(nameLookup, "D");

// I'm assuming your edges are undirected.
// If the edges are directed then the entries needn't be semmetric.
// A is connected to B
matrix[nodeA][nodeB] = true;
matrix[nodeB][nodeA] = true;
// A is connected to D
matrix[nodeA][nodeD] = true;
matrix[nodeD][nodeA] = true;
// B is connected to D
matrix[nodeB][nodeD] = true;
matrix[nodeD][nodeB] = true;
// C is connected to D
matrix[nodeC][nodeD] = true;
matrix[nodeD][nodeC] = true;

// Check if node X is connected to node Y
int nodeX = Arrays.binarySearch(nameLookup, stringNameOfX);
int nodeY = Arrays.binarySearch(nameLookup, stringNameOfY);

if (matrix[nodeX][nodeY]) { /* They're connected */ }

// Print all of node Z's neighbors' names
int nodeZ = Arrays.binarySearch(nameLookup, stringNameOfZ);
for (int i=0; i<matrix.length; i++) {
  if (matrix[nodeZ][i]) {
    System.out.println(nameLookup[nodeZ] + " is connected to " + nameLookup[i]);
  }
}