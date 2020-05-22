public int compareTo(Product that) {
  if(this.power != that.power) {
    return String.valueOf(this.power).compareTo(String.valueOf(that.power));
  } 
  else {
    return this.model.compareTo(that.model);
  }
}