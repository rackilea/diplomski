double DELTA = 10^-6//your error threshold here
double STEP_SIZE = 10.0;
double oldValue=Double.MAX_VALUE;
double newValue=oldValue;
double lowerBound=-10; //or whatever you want to start with--for (-infinity,1), I'd
                       //start with something like -10
double upperBound=1;

do{
     oldValue = newValue;

     lowerBound-= STEP_SIZE;
     newValue = integrate(lowerBound,upperBound); //perform your integration methods here
}while(Math.abs(newValue-oldValue)>DELTA);