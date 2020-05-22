List<Integer> xPos = IntStream.rangeClosed(0,10).boxed().collect(Collectors.toList());
List<Integer> yPos = IntStream.rangeClosed(0,10).boxed().collect(Collectors.toList());

Collections.shuffle(xPos);
Collections.shuffle(yPos);


for(int i=0;i<10;i++)
    grid.place(xPos.get(i), yPos.get(i));