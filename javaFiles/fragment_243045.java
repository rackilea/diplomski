public boolean isValid(final String userName,final String password)
{
    for(int i=0;(i+2)<userName.length();i++)
          if(password.indexof(userName.substring(i,i+2))!=-1)
                return false;
    return true;
}