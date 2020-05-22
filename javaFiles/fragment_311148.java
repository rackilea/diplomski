ArrayList<String> myList = new ArrayList<String>();

myList.add("FirstName");
myList.add("Another FirstName");
myList.add("John");

myList.add("SurName");
myList.add("Another SurName");
myList.add("Smith");

myList.add("Dob");
myList.add("Another Dob");
myList.add("31/1/1994");

int stride = myList.size() / 3;
for (int row = 0; row < myList.size() / 3; row++) {
    System.out.println(String.format("%20s %20s %12s", myList.get(row),
            myList.get(row + stride), myList.get(row + stride * 2)));
}