// this is what the login screen calls
void updateLoginDate(Date date)
{
    User user = session.get(User.class);
    user.setDate(date);
    session.Flush();
}