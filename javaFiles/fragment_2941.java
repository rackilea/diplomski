String prev = "";
for(Ami ami : value.getResults())
{
  String currentName = ami.getName();
  if(prev.compareTo(currentName) > 0)
  { 
     return false;
  }
  prev = currentName;
}
return true;