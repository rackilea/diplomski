ArrayList<Person> filtered = new ArrayList<>();

for (Person p : originalPeople)
{
    //region filtering
    if (p.fullName.toLowerCase().contains(constraint) ||
        p.getShortUsername().contains(constraint) ||
        p.getLongUsername().contains(constraint))
    {
        filtered.add(p);
    }
    else if (p instanceof Student)
    {
        Student s = (Student) p;
        if (s.mngClass.name.contains(constraint))
        {
            filtered.add(p);
        }
    }
    else if (p instanceof Teacher)
    {
        Teacher t = (Teacher) p;
        if (t.acronym.toLowerCase().contains(constraint))
        {
            filtered.add(p);
        }
    }
    //endregion
}

results.values = filtered.toArray();
results.count = filtered.size();