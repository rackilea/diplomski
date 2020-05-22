int weight = 50;
int barWeight = 45;

int weightWithoutBarWeight = weight - barWeight;

float fortyFives = (weightWithoutBarWeight / 2f) / 45f;
float thirtyFives = ((weightWithoutBarWeight / 2f) - (fortyFives * 45)) / 35f;
float twentyFives = ((weightWithoutBarWeight / 2f) - (fortyFives * 45) - (thirtyFives * 35)) / 25;
float tens = ((weightWithoutBarWeight / 2f) - (fortyFives * 45) - (thirtyFives * 35) - (twentyFives * 25)) / 10f;
float fives = ((weightWithoutBarWeight / 2f) - (fortyFives * 45) - (thirtyFives * 35) - (twentyFives * 25) - (tens * 10)) / 5f;
double twosFloat = ((weightWithoutBarWeight / 2f) - (fortyFives * 45) - (thirtyFives * 35) - (twentyFives * 25) - (tens * 10) - (fives * 5)) / 2.5f;
int twos = (int)twosFloat;

System.out.println(twosFloat);