void findPath(Set paths, Stack path, int[] nextSteps, Set numbersLeft) {
    if (numbersLeft.isEmpty()) {
        //Done
        paths.add(new ArrayList(path));
        return;
    }

    for (int step:nextSteps) {
        if (numbersLeft.contains(step)) {
            // We can move on
            path.push(step);
            numbersLeft.remove(step);
            findPath(paths, path, possiblePaths.get(step), numbersLeft);
            numbersLeft.add(path.pop());
        }
    }       
}