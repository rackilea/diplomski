listOfDVDs list = new listOfDVDs();

while (sc.hasNext()) {
    name = sc.next();
    year = sc.nextInt();
    director = sc.next();

    //create a DVD.
    DVD dvd = new DVD(name, year, director);
    //add it to the list
    list.add( dvd );
}

//return the result to the caller of the method.
return list;