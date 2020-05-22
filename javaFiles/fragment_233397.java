public Integer calculateCostForElapsedTimeSoFar ( final Instant start , final Integer price )
{
    // Determine elapsed time.
    Instant now = Instant.now();
    Duration elapsed = Duration.between( start , now );

    // See how many chunks of 15 minutes have occurred.
    Duration chunk = Duration.ofMinutes( 15 ); // Charge for every chunk of time in chunks of 15 minutes. You could make this a constant instead of a local variable.
    int chunks = Math.toIntExact( elapsed.dividedBy( chunk ) );   // Returns number of whole times a specified Duration occurs within this Duration.

    // Calculate charges.
    Integer cost = ( price * chunks );
    return cost;
}