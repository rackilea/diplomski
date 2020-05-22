===== source =====
class Test {                                 
  String s = " ... \" // no comment ";   
  /*                                         
   * also no comment: // foo                 
   */                                        
  char quote = '"';                         
  // yes, a comment, finally!!!              
  int i = 0; // another comment              
}                                            

==================
Found a SingleLineComment on line 7, starting at column 2, text: // yes, a comment, finally!!!              
Found a SingleLineComment on line 8, starting at column 13, text: // another comment