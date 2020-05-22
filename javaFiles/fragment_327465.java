Course newObject = new Course();//constructor requires 3 params of String, String and int, what you get as compile time error.
CourseListQ2 newList = new CourseListQ2();
while(nextLine!=null){//you are not reading the next line, so it will be a infinite loop after reading the first line of file
    newList.addCourse(newObject);//adding same course object instead you need different courses from each line
} 
return newList;//must be after the below line
inFile.close();//in future compiler is gona give error for writing below return keyword