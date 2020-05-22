int number = 7; //just an example, here binary rep: 00111 => requested output will be 10011
    System.out.println("number = " + Integer.toBinaryString(number));
    int mask3Bit = 4;//binary rep: 0100
    System.out.println("mask3Bit = " + Integer.toBinaryString(mask3Bit));

    int mask5Bit = 16; //binary rep: 10000
    System.out.println("mask5Bit = " + Integer.toBinaryString(mask5Bit));

    // now we'll create a mask that has all the bits on except the 3rd and 5th bit:
    int oppositeMask = -1;
    oppositeMask ^= mask3Bit;
    oppositeMask ^= mask5Bit;
    System.out.println("oppositeMask = " + Integer.toBinaryString(oppositeMask));

    //check if the 3rd bit is on:
    mask3Bit = number & mask3Bit;
    //shift twice to the right
    mask3Bit <<= 2;
    System.out.println("mask3Bit = " + Integer.toBinaryString(mask3Bit));
    //now do the same with the 5th bit
    //check if the 5th bit is on:
    mask5Bit = number & mask5Bit;
    //shift twice to the right
    mask5Bit >>= 2;
    System.out.println("mask5Bit = " + Integer.toBinaryString(mask5Bit));

    //now we'll turn off the 3rd and 5th bits in the original number
    number &= oppositeMask;
    System.out.println("number = " + Integer.toBinaryString(number));
    //and use the masks to switch the bits
    number |= mask3Bit;
    number |= mask5Bit;
    //let's check it out now:
    System.out.println("new number = " + Integer.toBinaryString(number));