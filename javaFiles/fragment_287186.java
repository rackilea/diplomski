int xValue = 5;

int howManyUnknowParamsHasFunction = 1;
int howManyDeriviationWillYouTake = 2;
int whatIsTheIndexOfThisParameterX = 0;

DerivativeStructure x = new DerivativeStructure(howManyUnknowParamsHasFunction, howManyDeriviationWillYouTake, whatIsTheIndexOfThisParameterX, xValue);

// x --> x^2.
DerivativeStructure x2 = x.pow(2);

//y = 2x^2 + 3x + 7
DerivativeStructure y = new DerivativeStructure(2.0, x2, 3.0, x).add(7);