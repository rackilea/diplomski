while ((line = file.readLine()) != null)
{
    if( line.matches("\\((.*?)\\)") ) // Match string between two parantheses  
    {
         String trimmedLine = line.subString(1, line.length - 1); // Takes the string without parantheses
         String[] result = trimmedLine.split(" "); // Split at white space   
    }
}

// result[0] is row#
// result[1] is col#
// result[2] is value