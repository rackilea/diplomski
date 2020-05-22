public <E> boolean rand_Function(List<E> tree, List<E> array) {

    if (array.isEmpty()) {
        return true;
    }
    if (array.size() == 1) {
        preorder = (List<Element>) new ArrayList<E>(tree);
        preorder.addAll((Collection<? extends Element>) array);
        for (Element e : preorder) {
            e.setLevel(0);
        }
        E1 = getAverageAccessTime(preorder);
        listTwo = new ArrayList<Element>(preorder);
        if ((E1 < E) || (rand.nextDouble() <= Math.exp(-(Math.abs(E1 - E)) / 0.5 * T))) {
            E = E1;
            listOne = listTwo;

        } else {
            noSolution++;
        }
        balance--;
        System.out.println("running"); // EDITED
        if (balance == 0 && noSolution ==1) {              
            noSolution = 0;
            T = 0.95 * T;           

        } else if (balance == 0 && noSolution == 0) {
            System.out.println("running");//EDITED
            return false;
        }

    } else {
        for (int i = 0; i < array.size(); i++) {
            //create a list without the ith element
            List<E> newList = new ArrayList<E>(array);
            newList.remove(i);
            //create a list by adding the ith element to beginning
            List<E> newBeginning = new ArrayList<E>(tree);
            newBeginning.add(array.get(i));
            if (!rand_Function(newBeginning, newList))
                return false;
        }
    }
    return true;
}