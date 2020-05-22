for (int x = 0; x < scoreList.size(); x++)

    {
        ArrayList<Float> finalscore = new ArrayList();
        finalscore.add(scoreList.get(x) / totalList.get(x));
        for (int j = 0; j < finalscore.size(); j++)

        {
            CalculateActivity.this.gradesList.add(finalscore.get(j));
        }
    }