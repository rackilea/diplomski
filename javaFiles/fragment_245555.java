private void generateInOverworld(World world, Random random, int x, int z) {
    for(int i = 0; i < 17; i++) { //20 = Rarity
        int chunkX = x + random.nextInt(16);
        int chunkY = random.nextInt(28); //= how high generates
        int chunkz = z + random.nextInt(16);

        (new WorldGenMinable(halo.Titanium_Ore, 6)).generate(world, random, chunkX,  chunkY, chunkz); //8 = number per vein
    }
    for(int i = 0; i < 24; i++) { //20 = Rarity
        int chunkX = x + random.nextInt(16);
        int chunkY = random.nextInt(45); //= how high generates
        int chunkz = z + random.nextInt(16);

        (new WorldGenMinable(halo.Copper_Ore, 7)).generate(world, random, chunkX, chunkY, chunkz); //8 = number per vein
   }
}