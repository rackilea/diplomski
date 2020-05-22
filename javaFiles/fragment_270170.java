String[] name = {"John", "Mike", "Jim"};

// this out put will be like this 
[ John, Mike, Jim ]
System.out.prinln(Arrays.asList(name));


// this way is better for formatting. Prints:
John
Mike
Jim
for (String s : name){
    System.out.println(s);     
}

// or this will print out
John Mike Jim
System.out.println(Arrays.toString(name));