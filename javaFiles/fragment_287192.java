// The following three initially uninitialized fields are exclusively
// managed by class java.util.concurrent.ThreadLocalRandom.
/** The current seed for a ThreadLocalRandom */
long threadLocalRandomSeed;
/** Probe hash value; nonzero if threadLocalRandomSeed initialized */
int threadLocalRandomProbe;
/** Secondary seed isolated from public ThreadLocalRandom sequence */
int threadLocalRandomSecondarySeed;