powerset(string) {
  add string to set;
  add powerset2(string,0) to set;
  return set
}

powerset2(string,pos) {
  if pos<length(string) then
    let substring = (string excluding the char at pos)
    add powerset(substring) to set
    add powerset2(string,pos+1) to set
  else 
    add "" to set
  endif
  return set
}