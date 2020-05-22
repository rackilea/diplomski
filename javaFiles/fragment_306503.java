student(String informedFirstName, String informedLastName, int informedAge,
        String informedStatus)
{
    super(informedFirstName, informedLastName, informedAge);
    if (age <= 25) status = informedStatus = "Traditional";
    else status = informedStatus = "Non-Traditional";
}