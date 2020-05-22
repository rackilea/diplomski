BufferedReader bf = new BufferedReader(new FileReader("MyFile.txt"));

for(int i = 1; i < myVertex.vertexId; i++){
    bf.readLine();
}

String n = bf.readLine();
if(n != null){
    System.out.println(n);
}