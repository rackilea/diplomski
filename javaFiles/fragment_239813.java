public void uniformCrossover(ArrayList<Integer> a, ArrayList<Integer> b){
    for (int i = 0; i <a.size(); i++) {
        if(Math.random() < crossoverProbability){
            int tmp = a.get(i);
            a.set(i, b.get(i));
            b.set(i, tmp);
        }
    }
}