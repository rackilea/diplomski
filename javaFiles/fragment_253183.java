while ((tmp = bis.read(block)) > 0) {
    byte[] currentBlock = new byte[tmp];
    System.arraycopy (block, 0, currentBlock, 0, tmp);
    System.out.println(tmp);
    blockList.add(currentBlock);           
}