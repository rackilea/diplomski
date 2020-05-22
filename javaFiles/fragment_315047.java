FileWriter fw;
for(int i=0;i<n;i++){
    fw = new FileWriter(new File("C:\\Users\\Netbook\\Exits\\output" + i + ".txt"));
    for(int j=0;j<8;j++){
        fw.write(datos[i][j] + " ");
    }
    fw.flush();
    fw.close();
}