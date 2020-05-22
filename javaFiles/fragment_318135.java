int i=0;

while (request.getParameter("field" + Integer.toString(i)) != null) {

    // Add to ArrayList

    i++; // very important, don't forget this one
}

// i is the count of fields at this point