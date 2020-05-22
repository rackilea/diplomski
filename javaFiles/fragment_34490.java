EvanContainer[] container = new EvanContainer[weights.length];
for(int i = 0; i < weights.length; i++) {
    container[i] = new EvanContainer(weights[i],values[i]);
}

Arrays.sort(container);