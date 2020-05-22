powerset(string) {
  add string to set;
  for each char in string {
   let substring = string excluding char,
   add powerset(substring) to set
  }
  return set;      
}