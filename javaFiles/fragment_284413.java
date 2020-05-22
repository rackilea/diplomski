<%
String theAnswer1 = ...  
String userAnswer = (String)session.getAttribute("s1");
if (theAnswer.equals(userAnswer)) {
   out.println("Answer1 is correct - woohoo!");
} else {
   out.println("Question 1: Wrong answer - Correct answer is: " + theAnswer1)
}    
%>