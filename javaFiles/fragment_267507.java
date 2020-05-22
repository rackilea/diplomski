static void demo1(Personne[] pers, int amount){
    int count = 0;
    final String juillet = "07";
    for (int i=0; i<amount; i++)
        if (pers[i].naissance.substring(3,5).equals(juillet)) {
            count++;
        }
        System.out.println(count);
   }
}