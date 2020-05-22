String s = "2*-5+ sin(1.5*4)+(28- 3^4-(cos(3+(19*3)+1+(6/2))/2+tan(1+cos(1+9))-6/3+2.3*3.3345)+1)+1)-(4/2)";  
System.out.println("cos: " + getBalancedStr(s, "cos", '(', ')', true)); 
// cos: [cos(3+(19*3)+1+(6/2)), cos(1+9)]
System.out.println("sin: " + getBalancedStr(s, "sin", '(', ')', true)); 
// sin: [sin(1.5*4)]
System.out.println("tan: " + getBalancedStr(s, "tan", '(', ')', true)); 
// tan: [tan(1+cos(1+9))]