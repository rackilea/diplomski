List<Float> depthCopy = new ArrayList<>(depthAdd);
Collections.sort(depthAdd);
Float max = depthAdd.get(depthAdd.size() - 1);
for (int i = 0; i < depthCopy.size(); i++) {
    if (depthCopy.get(i).equals(max)) {
        System.out.println("Wettest year: " + (1930 + i) + " "
                + depthAdd.get(depthAdd.size() - 1));

    }
}