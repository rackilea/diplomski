public void txtAnalysis(String line){
    if(line.startsWith("start picture")){
       String label = line.split(" ")[2];
       currentPicture = new Picture(label);
    }
    if(line.startsWith("end picture")){
       save(currentPicture);//or pictures.put(currentPicture.getLabel(), currentPicture);
       currentPicture = null;
    }
    if(line.startsWith("circle")){
       String[] parts = line.split(" ");
       currentPicture.addShape(new Cirlce(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
    }
    if(line.startsWith("draw picture")){
       String[] parts = line.split(" ");
       Picture pic = pictures.get(parts[2]);
       pic.draw(parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
    }
    ...
}