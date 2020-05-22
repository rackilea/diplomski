int numBlocks = objects.size();
for(int loop = 0; loop < numBlocks; loop++)
{
    Block block = objects.get(loop);
    g2d.drawImage(block.image, block.x, block.y, null);
}