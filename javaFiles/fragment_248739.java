Classroom[] classarray = new Classroom[3];


        //here you need to initialize all elements of the array
        classarray[0]=new Classroom();
        classarray[1]=new Classroom();
        classarray[2]=new Classroom();

        classarray[0].classroomreader("class1"); 


        classarray[0].setClassname(classarray[0].classroomarray[1]);

        System.out.println(classarray[0].getClassname());// here you'll surely get the the desired results
    }
}