double[] result = new double[vect.length];
double sum = 0;
for (int i = 0; i < vect.length ; i++) {
    sum += Math.pow(vect[i], 2);
}
for (int i = 0; i < vect.length ; i++) {
    result[i] = vect[i] / Math.sqrt(sum);
}
return result;