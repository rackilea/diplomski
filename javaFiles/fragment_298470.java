/**
 * Determines if the exception has already been posted to the issue page.
 * Returns false if an error occurs.
 * @param e
 * @return
 */
private static boolean DoesIssueAlreadyExist(String Title, String Report)
{  
  try
    {
        EnumMap<Qualifier, String> qualifiers = new EnumMap<Qualifier, String>(Issues.Qualifier.class);

        Iterable<Issue> Issues = repo.issues().search(Sort.CREATED, Order.DESC, qualifiers);

        Issue.Smart current;

        long size = Iterables.size(Issues);

        int i = 0;


        while (i != size)
        {
            current = new Issue.Smart(Issues.iterator().next());

            if (current.title().contains(Title) && current.body().contains(Report))
            { 
                return true;
            }

            i++;
        }

        return false;

    }
    catch (Exception e)
    {
        e.printStackTrace();
        return true;
    }
}