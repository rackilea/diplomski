Node A = new Node(); 
Node B = new Node(); 
Node C = new Node(); 
Node D = new Node(); // Defines non-null A, B, C, and D Nodes

B = A.Next; // B = null; because the Next and Data of each node is null

C = B.Next; // C = (a non existent) b.next causing a null pointer error
B.Data = C.Next.Data; // c.next == null. null.Data doesn't exist. 

C.Next = A; // C.Next = A; A == new Node(); no error