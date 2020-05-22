flowerName = flowerInput.nextLine();
for(int i=0; i<flowerPack.length; i++){
    if(flowerPack[i] == null || flowerPack[i].equalsIgnoreCase("")){
        flowerPack[i] = flowerName;
        break;
    }
}