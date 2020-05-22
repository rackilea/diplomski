public int hashCode() {
    int hash = 17;
    hash = ((hash + x) << 5) - (hash + x);    
    hash = ((hash + y) << 5) - (hash + y);   
    return (int)hash;
  }