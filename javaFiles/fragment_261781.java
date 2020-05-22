Assessment[] element;

public Ratin()
{
    element = new Assessment[4];
}

public void setLab(Assessment assessment)
{
    assessment.setScore(85);
    element[0] = assessment;
}