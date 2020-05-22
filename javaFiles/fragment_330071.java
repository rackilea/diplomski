Random r = new Random();

int n = carte.size();
for (int i = n - 1; i > 0; i--) {  
    int j = r.nextInt(i + 1); 

    Carta temp = carte.get(i); 
    carte.put(i, carte.get(j));
    carte.put(j, temp);
}