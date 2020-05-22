List<Block> blocks = new LinkedList<Block>();
Random rnd = new Random(System.currentTimeMillis());

int x = 400;

while (youNeedMoreBlocks)
{
    int offset = rnd.nextInt(400) + 100; //500 is the maximum offset, this is a constant
    x += offset;                         //ofset will be between 100 and 400

    blocks.add(new Block(R.drawable.block, x, platformheight));

    //if you have enough blocks, set youNeedMoreBlocks to false
}