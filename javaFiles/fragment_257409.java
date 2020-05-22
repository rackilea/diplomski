String lines ;
while((lines = getLine()) != null){
                String[] lineArray = lines.split(":");
                System.out.println(lineArray[0]);
                flashcards.add(new FlashCard(lineArray[0],lineArray[1]));
            }