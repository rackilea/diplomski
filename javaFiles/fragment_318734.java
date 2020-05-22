public static void setUnlocked(int id, boolean set)
{
    if (set) {
        unlocked |= 1L<<id; // set the id'th bit
    } else {
        unlocked &= 0xffffffffffffffffL ^ (1L<<id); // clear the id'th bit
    }
}