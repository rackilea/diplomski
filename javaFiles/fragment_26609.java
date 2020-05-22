while (result1.next()) {
        System.out.println(result1.getString(1) + " " + result1.getString(2));
// instead of returning from here , you can create labels and set the text
// and return a List of labels.
        return result1.getString(1) + " "+ result1.getString(2); 
}