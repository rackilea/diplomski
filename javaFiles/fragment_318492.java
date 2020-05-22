try
{
   if (!(side1 + side2 > side3) && (side2 + side3 > side1) && 
        (side1 + side3 > side2))

       message = "Invalid Triangle";

} catch (InvalidValueException e) {
    message = "Invalid Traingle";
}