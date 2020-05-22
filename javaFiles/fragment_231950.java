/** Java style PRNG */
public class Random
{
    var seed : UInt32 = 0

    init( _ seed : UInt32 ) {
        self.seed = seed
    }

    /** float 0-1.0 */
    public func nextFloat() -> Float {
        return Float(rand_r(&seed)) / Float(INT32_MAX);
    }

}