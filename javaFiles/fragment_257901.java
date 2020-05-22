float qCoeff = 1.0f, lCoeff = -2.0f, constant = 3.0f;
char lSign = lCoeff < 0 ? '-' : '+';
char constSign = constant < 0 ? '-' : '+';

System.out.printf("Equation: %.5fx^2 %c %.5fx %c %.5f = 0.00000%n", 
                   qCoeff, lSign, Math.abs(lCoeff), constSign, Math.abs(constant));