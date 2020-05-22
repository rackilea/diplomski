class User {
    String userName;
    /*
     * 
     * Do whatever 
     * 
     */

    @Override
    public boolean equals(Object object)
    {
        boolean theSame = false;

        if (object != null && object instanceof User)
        {
            theSame = this.userName.equals(((User) object).userName);
        }

        return theSame;
    }
}