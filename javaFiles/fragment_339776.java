int largestMark = 0;
inst smallestMark = 9999;
for(int i=0; i<students.size(); i++)
    {
        if(students.get(i).getMark() < smallestMark)
        {
            smallestMark = students.get(i).getMark();
            smallest = students.get(i).getID();
        }

        if(students.get(i).getMark() > largestMark)
        {
            largestMark = students.get(i).getMark();
            largest = students.get(i).getID();
        }
    }