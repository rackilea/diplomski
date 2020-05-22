// adding all the vars to an array might improve readability
boolean checks[] = new boolean[] { endbox, coursebox, departmentbox, callbox,
                                   daybox, startbox, instructorbox, roombox,
                                   buildingbox, numberenrolled };

for (boolean check : checks) {
    if (check) {
        totalOutPuts++;
    }
}

String groupBy = " Group by ";

// this isn't the best way of appending strings in Java,
// you'd be better using StringBuilder. this is for the sake of simplicity
for (int i = 1; i < totalOutPuts; i++) {
    groupBy += i + ", ";
}

// append the last number
groupBy += totalOutPuts + "";