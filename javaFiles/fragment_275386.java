// Bond class
double calculateValue() {
  if(_type == BTP)  { 
    return calculateBTPValue();
  } else if(_type == BOT) { 
    return calculateBOTValue();    
  } else {
    return calculateEUBValue();
  }
}