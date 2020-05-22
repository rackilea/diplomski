public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (!(obj instanceof LdapUserDetails)) //check class here
        return false;

    // check fields for equality here
}