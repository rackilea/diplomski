String[] splitter = uData.split(" ");
ID = Integer.parseInt(splitter[0]);
ArrayList<String> studentsList = students.get(ID);//get the existing list from Map
if(studentsList == null) {//if no list for the ID, then create one
    studentsList= new ArrayList<>();
}
studentsList.add(0, splitter[1]);//add to list
students.put(ID, studentsList);//put the list inside map