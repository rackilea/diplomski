ArrayList<Long> numbers = new ArrayList<Long>();

while (variable > 0){
    number = variable %10;
    variable/=10;
    numbers.add(number);
}

for (int i=0; i< numbers.size(); i++) {
    sum1 += numbers.get(i);
}