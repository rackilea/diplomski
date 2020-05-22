// Open the OBJ file "MyObject.obj" 
OBJWriter writer = new OBJWriter("MyObject.obj"); 

// Write one node or more if you want 
writer.writeNode(java3DNode1); 
writer.writeNode(java3DNode2); 
// ... 

// Close file. This will create the MTL file and texture files in same directory 
writer.close();