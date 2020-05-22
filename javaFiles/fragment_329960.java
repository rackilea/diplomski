boolean success 
    = content.contains("foo") 
    || content.contains("Charoit") 
    || content.contains("Micha");
Assert.assertEquals
    ("content contains 'foo', 'Charoit', or 'Micha'", true, success);