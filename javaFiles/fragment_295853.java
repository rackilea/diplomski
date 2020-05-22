SecureRandom random = new SecureRandom();
boolean inserted;
do{
    inserted = true;
    int id = random.nextInt(MAX_VALUE);
    for (int i=0; i<arr.size();i++){
        if (arr.get(i) == id)
            inserted = false;
    }
    if (!inserted){
        arr.add(id);
        pstmt.setInt(6,id);
    }
}while(!inserted);