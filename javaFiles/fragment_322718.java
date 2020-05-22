// "normals" is CopyOnWriteArrayList<Float> filled with actual normals defined in OBJ file
// "indicesPairs" is CopyOnWriteArrayList<int[]> filled during OBJ file parsing
// it takes "f v/vt/vn" or "f v//vn" and makes array of 1st & 3rd value "new int[]{v, vn}"
// both values are lowered by 1 as index starts at 0, not 1
// also any duplicate is removed so it has the right expected length: "vertices.length/3"
Collections.sort(indicesPairs, (o1, o2) -> {
    for (int i = 0; i < o1.length; i++) {
        if (o1[i] < o2[i]) {
            return -1;
        }
        if (o1[i] > o2[i]) {
            return 1;
        }
    }
    return 0;
});

for (int i = 0; i < indicesPairs.size(); i++) {

    int normalsBlock = indicesPairs.get(i)[1];

    float n1 = normals.get(normalsBlock * 3);
    float n2 = normals.get((normalsBlock * 3) + 1);
    float n3 = normals.get((normalsBlock * 3) + 2);

    normalsNew.add(n1);
    normalsNew.add(n2);
    normalsNew.add(n3);
}