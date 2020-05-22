private String DEFAULT_NAME = "User not available";

private String name;

public String getName(){
  if(null == name) return DEFAULT_NAME;
  return name; 
}