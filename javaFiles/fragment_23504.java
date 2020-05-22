interface UserDao
{
    /**
     * Store the new user and assign a unique auto-generated ID.
     */
    function create($user);

    /**
     * Return the user with the given auto-generated ID.
     */
    function findById($id);

    /**
     * Return the user with the given login ID.
     */
    function findByLogin($login);

    /**
     * Update the user's fields.
     */
    function update($user);

    /**
     * Delete the user from the database.
     */
    function delete($user);
}