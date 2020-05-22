DataInputStream main = new DataInputStream(input);
   int blockType = main.readInt();
   int blockLength = main.readInt();
   // next N bytes are the data
   LimitInputStream data = new LimitInputStream(main, blockLength);

   if (blockType==BINARY) {
      handleBinaryBlock(new DataInputStream(data));
   }
   else if (blockType==OBJECTSTREAM) {
      deserialize(new ObjectInputStream(data));
   }
   else
      ...