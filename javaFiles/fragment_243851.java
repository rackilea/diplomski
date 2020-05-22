FileOutputStream file = new FileOutputStream("treeModel.obj"); 
ObjectOutputStream out = new ObjectOutputStream(file); 

out.writeObject(treeModel); 
out.close(); 
file.close();