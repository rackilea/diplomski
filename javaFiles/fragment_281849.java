String output = "";
for (index = 0; index <= input; index++)
    input = EasyIn.getInt();
    result = isNum(input);

    if(result == true)
    {
        numCount++;
        output += input.ToString() + ", "; // you will probably want to remove the last comma
    }
}

output = output.replaceAll(", $", ""); // remove last comma
System.out.println("Total numbers below 10 is " + numCount); 
System.out.println("The numbers below 10: " + output)