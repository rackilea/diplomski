try (ObjectOutputStream saveStream = new ObjectOutputStream(
        new FileOutputStream("src\\Constellations\\" + 
                             constellation.getNazwa() + ".obj"))) {
    saveStream.writeObject(constellation);
    this.constellation = constellation;
} catch (IOException e){
    e.printStackTrace();
}