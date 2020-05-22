public static double squareRoot(double a){

    double guess = a/2;
    double improvedGuess = (guess + (a/guess))/2;

    while (Math.abs((guess - improvedGuess)) > 0.0001){
        guess = improvedGuess;
        improvedGuess = (guess + (a/guess))/2;
    }
    return improvedGuess;
}