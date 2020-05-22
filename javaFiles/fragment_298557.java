public int averageGrade() {
        int totalGrade=0;
        int i = 0;
        for (; i < results.size(); i++);
        {
            TestResult theResult = results.get(i);
            totalGrade += theResult.getGrade();
        }
        if (i>0)
           return totalGrade/i;
        else return 0;

    }