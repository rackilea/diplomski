for(int i=0; i<students.size(); i++)
    {
        if(students.get(i).getMark() < smallest)
        {

            smallest = students.get(i).getID();
        }

        if(students.get(i).getMark() > largest)
        {

            largest = students.get(i).getID();
        }
    }