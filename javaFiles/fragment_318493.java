public Triangle2(int a,int b,int c) throws InvalidValueException

      if (!(side1 + side2 > side3) && (side2 + side3 > side1) && 
            (side1 + side3 > side2))

           throw new InvalidValueException("Invalid Value")
}