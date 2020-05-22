@Override
public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
        .append("email", email)
        .append("password", password)
        .toString();
}