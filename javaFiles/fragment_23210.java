float[][] fa2 = {{7,2}, {5,4}, {9,6}, {4,7}, {8,1}, {2,3}};
ArrayList<Float[]> AF = new ArrayList<Float[]>();
for(float[] fa: fa2) {
    Float[] temp = new Float[fa.length];
    for (int i = 0; i < temp.length; i++) {
        temp[i] = fa[i];
    }
    AF.add(temp);
}