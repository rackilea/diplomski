public static void main(String[] args) 
{
  string output;
  string fname = readFileName();
  if (fileValid(fname)) //Ensure FileExists
  {
     int lineCount = scaneFile(fname);   
     output = "some output text including line numbers"   
  }  
  else
  {
    output = "File Not Valid..."
  }
  //showOutput...
}