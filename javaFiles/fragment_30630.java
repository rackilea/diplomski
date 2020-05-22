List<Block> blocks = new LinkedList<Block>();
Random rnd = new Random(System.currentTimeMillis());

int x = 400;

while (youNeedMoreBlocks)
{
    int offset = rnd.nextInt(400) + 100; //500 is the maximum offset, this is a constant
    x += offset;                         //ofset will be between 100 and 400

    Block tmp = new Block(R.drawable.block, x, platformheight);
    tmp.setY(three_quarters - 10);                 
            //do with tmp everything you need to apply to each block

    blocks.add(tmp);

    //if you have enough blocks, set youNeedMoreBlocks to false
}