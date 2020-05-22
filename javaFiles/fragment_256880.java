String listPrereq = "";

for (int i = 0; i < numPrereqs; i++) {
    System.out.print("List Pre-requisite #" + (i+1) + "? ");
    listPrereq += console.nextLine();
    if (i != numPrereqs - 1)
        listPrereq += ",";
} // Close for loop

// To print:
System.out.println(listPrereq);