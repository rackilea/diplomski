package test;

import java.util.ArrayList;

public class Test {

    static class Block {};

    static class OreBlock extends Block {};

    public static void main(String[] args) {

        Block[] arrayOfBlocks = new Block[] {new Block(), new OreBlock(), new Block(), new OreBlock()};
        ArrayList<OreBlock> arrayListOfOreBlocks = new ArrayList<OreBlock>();
        for(Block block : arrayOfBlocks){
            if(block != null && block instanceof OreBlock){
                arrayListOfOreBlocks.add((OreBlock)block);
            }
        }
        OreBlock[] arrayOfOreBlocks = arrayListOfOreBlocks.toArray(new OreBlock[arrayListOfOreBlocks.size()]);
        System.out.println(arrayOfOreBlocks.length);
    }

}