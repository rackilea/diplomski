List<Var> unassigned = new ArrayList<>();
Var grabNear;
for(int i = 0; i < assigned.size(); ++i)
{
    grabNear = assigned.get(i);
    if(!grabNear.isAssigned())
    {
        unassigned.add(grabNear);
    }
}