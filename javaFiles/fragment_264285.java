@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(AccountBalance);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((AccountName == null) ? 0 : AccountName.hashCode());
    result = prime * result + AccountNumber;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Account other = (Account) obj;
    if (Double.doubleToLongBits(AccountBalance) != Double.doubleToLongBits(other.AccountBalance))
        return false;
    if (AccountName == null) {
        if (other.AccountName != null)
            return false;
    } else if (!AccountName.equals(other.AccountName))
        return false;
    if (AccountNumber != other.AccountNumber)
        return false;
    return true;
}