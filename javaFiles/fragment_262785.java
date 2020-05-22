public static void main(String args[])
{
    List<Profile> profiles;

    // You'll have to figure out how to load these yourself.
    // It sounds like this is probably the biggest part of the assignment.
    // It might not even be done here - maybe it's done in the Profile
    // class itself. Depends on how you want to implement it.
    profiles = loadProfiles(); 

    // Grab the first profile as a test. 
    testProfile = profiles.get(0);

    // Get whichever random profile was recommended.
    Profile recommendedProfile = testProfile.recommend();

    // Print them to the user. (You'll have to figure out how to do this best.)
    if (recommendedProfile != null)
        System.out.println("Test profile: " + testProfile.toString() +
                        " Recommended Profile: " + recommendedProfile.toString());
}