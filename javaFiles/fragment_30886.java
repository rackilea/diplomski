public void setRating(int aRating)
{
    if (isValidRating(aRating))
        this.rating = aRating;
    else 
        throw new IllegalArgumentException("Invalid rating.");
}