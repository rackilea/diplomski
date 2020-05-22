public User findUser(String username)
{
    // iterate through the array; only iterate according to how many users are currently in the array
    for (int i = 0; i < users.size(); i++)
    {
        // access the particular user through users.(i), then get the name,
        // and call the equals method on that name to compare it with the input username
        if (users.get(i).userName.equals(username)){
            return users.get(i);
        }

    }
    // no user found
    return null;
}