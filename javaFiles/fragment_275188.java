public Student[] deleteData (String firstName)  {
    for(int counter=0;counter< studentListArray.length;counter++){
         if(studentListArray[counter].getFirstName().equals(firstName)){
               for(int counter1= counter;counter< studentListArray.length-1;counter1++){
                    studentListArray[counter1]=studentListArray[counter1 +1];
               }
               studentListArray[counter1+1]=null;
               break;
         }
    }
}