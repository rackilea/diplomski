public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        boxHeight = in.readInt();
        boxWidth = in.readInt();
        mapHeight = in.readInt();
        mapWidth = in.readInt();
        map = ImageIO.read(in);
        in.readInt();// you read this int and assign it to the object as you wish
        encoded = (byte[][]) in.readObject();
        int tileSetSize = in.readInt();
        for(int i = 0; i < tileSetSize; i++){
            tileSet.add(ImageIO.read(in));
        }
    }