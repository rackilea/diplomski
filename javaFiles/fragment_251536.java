private ArrayList<String> tableContent;
Random rand = new

public YourClass yourConstructor () { // or MainActivity initializer if android studio
        mydManager.openReadable();    
        tableContent = mydManager.retrieveRows();
}

public String getQuestion() {
        int size = tableContent.size();

        int rand_int = rand.nextInt(size);
        String a = tableContent.get(rand_int);

        //remove the element from arraylist
        tableContent.remove(a);

        String[] myarray = a.split("\n");
        String Rquestion = (myarray[1]);
        question = findViewById(R.id.question);
        question.setText(Rquestion);

        return a;
}