int count = 0;
while(kb.hasNext()) {
    int i = kb.nextInt();
    if (count++ % 3 == 0) 
        System.out.println(i + " ");
    else 
        System.out.print(i + " ");
}