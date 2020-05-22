int splits = myString.length()/divisor;
int first = 0;
int second = divisor;
for (int i = 0; i < splits; i++) {
    arrayList.add(myString.substring(first, second));
    first += divisor;
    second += divisor;
}