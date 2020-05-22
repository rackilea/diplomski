// initialize size of buffer to a good estimate of what's required
StringBuilder output = new StringBuilder(k*18);
int last = 0;

for (int k=1; k<=user; k++) {
    // some other code here
    if (numFactors == 2) { // "k" is prime
        last = k;
        output.append(k).append(", ");
    }
    // some other code here
}

String lastText = Integer.toString(last);
int lastIndex = output.lastIndexOf(", " + lastText);
output.setLength(lastIndex);
output.append(" and " + lastText);