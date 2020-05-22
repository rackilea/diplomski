/**
 * Increments the score by the given amount.
 *
 * @param amount the amount to increment the score by; must not be negative
 * @throws IllegalArgumentException if the amount is negative
 */
public void incrementScore(int amount) {
  if (amount < 0) {
    throw new IllegalArgumentException("The increment must not be negative.");
  }
  score += amount;
}