private  String lastName;
   private String firstName;
   private int scores;

    public Student (String lastName, String firstName, int score)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.scores = score;
    }

    public int getScores()
    {
        return scores;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public int compareTo(Student s)
    {
       if (s.lastName.equals(lastName))
       {
           return firstName.compareToIgnoreCase(s.firstName);
       }
      return lastName.compareToIgnoreCase(s.lastName);
    }

    static class StudentScoreComparator implements Comparator<Student>
    {
        @Override
        public int compare(Student o1, Student o2)
        {
            return (Integer.valueOf(o1.getScores())).compareTo(o2.getScores());
        }
    }
    @Override
    public String toString() {
           return String.format("%s %s %d", firstName, lastName, scores);
    }