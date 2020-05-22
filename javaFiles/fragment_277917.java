Vector vector = (Vector) row.get(1);
        double[] vectorArray = vector.toArray();
        ArrayList<String> vectorList = new ArrayList<>();
        for (double vectorElement: vectorArray) {
            vectorList.add(String.valueOf(vectorElement));
        }