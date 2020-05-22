ArrayList<Integer> ar= new ArrayList<Integer>();
int[] number= {0,1,2,3,4,5};
for (int i : number) {
    ar.add(i);
}

Random r = new Random();

// repeat this part and you will never have duplicate numbers
int select = r.nextInt(ar.size());
int random = ar.get(select);
ar.remove(select);