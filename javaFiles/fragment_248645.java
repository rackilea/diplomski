public boolean equals(Object other)
{
    if (this == other)
    {
        return true;
    }

    // This also works if `other` is `null`
    if (!(other instanceof Student))
    {
        return false;
    }

    // Now we cast it to `Student`
    final Student student = (Student) other;

    if (this.getID() != student.getID())
    {
        return false;
    }

    return true;
}