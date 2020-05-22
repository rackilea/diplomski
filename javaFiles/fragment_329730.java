final File file = new File("../received/"+nameFiles.get(op-1));
try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true) )){
    for(String index : lines){
        bw.write(index);
        System.out.println(index);
    }
    System.out.println("Arquivo criado");
} catch(IOException ex){
    ex.printStackTrace();
}