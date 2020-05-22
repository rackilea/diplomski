public int compareTo(Product that) {
  if(this.power != that.power) {
    return this.power < that.power ? -1 : 1;
  } 
  else {
    return this.model.compareTo(that.model);
  }
}