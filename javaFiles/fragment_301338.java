public void translateWords(){
        String nameSearch;
        nameSearch=input.nextLine();

        Iterator<Phrase> it = phrases.iterator();
        while(it.hasNext())
        {
           Phrase c = it.next();
           if (c.getName().equals(nameSearch))  {
                System.out.println( it.next().advancedToString());      
                return;
            }
        }

        System.out.println("not on list");
}