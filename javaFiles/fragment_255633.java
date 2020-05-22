int min = weights[0];
int max = weights[0];
double avg = 0;

for (int weight : weights) {
    if (weight < min)
        min = weight;
    if (weight > max)
        max = weight;
    avg += weight;
}

avg /= weights.length;