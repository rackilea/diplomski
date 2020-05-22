class Child 
{
    private Section section;
    private Question question;

   // Constructor, etc...
}

class Question 
{
    private String name;
    // other fields, getters, and setters
}

class Section 
{
    private String label;
    private Child[] children;
    // getters and setters
}

class Quiz 
{
    private Child[] elements;
    // getter and setter
}