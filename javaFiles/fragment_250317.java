private List<String> extraTokens = ...
public boolean incrementToken() { 
  if (input.incrementToken()){ 
    // ... 
    return true; 
  } else if (!extraTokens.isEmtpy()) { 
    // set the added token and return true
    termAtt.setTerm(extraTokens.remove(0)); 
    return true; 
  } 
  return false; 
}