public Assignment getAssignmentByName(String name)
{
    for (Assignment assignment : assignments)
    {
        if (assignment.getName().equals(name))
            return assignment;
    }

    System.out.println("No assignment found by the name of " + name);
    return null;
}