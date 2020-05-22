for (int i = 0; i < operators.length; i++)
{
    if (operators[i] == "*")
        //Multiply your fractions
        //Something like this, I haven't used the Fraction class before, nor heard of it
        //Shouldn't throw out of bounds because the size should be 1 bigger
        newFractions[i+1] = newFractions[i].multiply(newFractions[i+1]);
    else if (operators[i] == "+")
        //Add your fractions
    else if (operators[i] == "-")
        //Subtract your fractions
    else if (operators[i] == "/")
        //Divide your fractions
}