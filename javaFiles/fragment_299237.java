/**
  * Initializes a newly created {@code String} object so that it represents
  * an empty character sequence.  Note that use of this constructor is
  * unnecessary since Strings are immutable.
  */
 public String() {
    this.offset = 0;
    this.count = 0;
    this.value = new char[0];
 }