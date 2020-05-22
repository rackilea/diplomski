public String trimOnlyLeadingSpace()
  {
    int i = this.count;
    int j = 0;
    int k = this.offset;
    char[] arrayOfChar = this.value;
    while ((j < i) && (arrayOfChar[(k + j)] <= ' '))
      ++j;
    return (((j > 0) || (i < this.count)) ? substring(j, i) : this);
  }