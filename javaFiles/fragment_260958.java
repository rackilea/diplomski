File idea=new File(dir,titulo+".txt");
if (!idea.exists()){
    FileWriter writer = new FileWriter(idea);
    texto.append("\n\n\tCreada :" + new Fecha().toString());
    return;
}