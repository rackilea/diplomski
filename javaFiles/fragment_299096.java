public class User{
    private String username;

    private String updated_at;

    private String _id;

    private String access_level;

    private String email;

    private String token;

    private String userid;

    private String __v;

    private String created_at;

    private Groups[] groups;

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getAccess_level ()
    {
        return access_level;
    }

    public void setAccess_level (String access_level)
    {
        this.access_level = access_level;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getToken ()
    {
        return token;
    }

    public void setToken (String token)
    {
        this.token = token;
    }

    public String getUserid ()
    {
        return userid;
    }

    public void setUserid (String userid)
    {
        this.userid = userid;
    }

    public String get__v ()
    {
        return __v;
    }

    public void set__v (String __v)
    {
        this.__v = __v;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public Groups[] getGroups ()
    {
        return groups;
    }

    public void setGroups (Groups[] groups)
    {
        this.groups = groups;
    }

}