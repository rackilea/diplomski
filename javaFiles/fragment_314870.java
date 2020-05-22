public class BitsExtractor
{
    public static int extract(byte[] bits, int[] sizes, int[] res)
    {

        int currentByte = 0;            //Index into the bits array
        int intProduced = 0;            //Number of ints produced so far
        int bitsLeftInByte = 8;         //How many bits left in the current byte
        int howManyInts = 0;            //Number of integers to extract 

        //Scan the sizes array two items at a time
        for (int currentSize = 0; currentSize < sizes.length - 1; currentSize += 2)
        {
            //Size, in bits, of the integers to extract
            int intSize = sizes[currentSize];

            howManyInts += sizes[currentSize+1];

            int temp = 0;                   //Temporary value of an integer
            int sizeLeft = intSize;         //How many bits left to extract 


            //Do until we have enough integer or we exhaust the bits array
            while (intProduced < howManyInts && currentByte <= bits.length)
            {
                //How many bit we can extract from the current byte
                int bitSize = Math.min(sizeLeft, bitsLeftInByte);               //sizeLeft <= bitsLeftInByte ? sizeLeft : bitsLeftInByte;
                //The value to mask out the number of bit extracted from
                //The current byte (e.g. for 3 it is 7)
                int byteMask = (1 << bitSize) - 1;
                //Extract the new bits (Note that we extract starting from the
                //RIGHT so we need to consider the bits left in the byte)
                int newBits = (bits[currentByte] >>> (bitsLeftInByte - bitSize)) & byteMask;

                //Create the new temporary value of the current integer by
                //inserting the bits in the lowest positions
                temp = temp << bitSize | newBits;

                //"Remove" the bits processed from the byte
                bitsLeftInByte -= bitSize;

                //Is the byte has been exhausted, move to the next
                if (bitsLeftInByte == 0)
                {
                    bitsLeftInByte = 8;
                    currentByte++;
                }

                //"Remove" the bits processed from the size
                sizeLeft -= bitSize;

                //If we have extracted all the bits, save the integer
                if (sizeLeft == 0)
                {
                    res[intProduced++] = temp;
                    temp = 0;
                    sizeLeft = intSize;
                }
            }
        }

        return intProduced;

    }
}