String s1 = "spring "; //One reference and 1 object in string pool. (if it didn't exist already)

String s2 = s1 + "summer "; //Two references and 3 objects

s1.concat("fall "); //Two references and 5 objects

s2.concat(s1); //Two references and 6 objects

s1 += "winter "; //Two references and 8 objects

System.out.println(s1 + " " + s2);