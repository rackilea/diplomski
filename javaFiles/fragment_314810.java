// Returns the combined probability (the odd indexes of the arraylist)
public BigFraction weight() {
    BigFraction sum;
    for (int index = 1; index < knowledge.size(); index = index + 2) {
        sum = sum.add(knowledge.get(index));
    }

    System.out.println("Sum is  " + sum);

    return sum;
}