<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>

        <title> name<title/>
    </head>

    <body>
      <form action="JavaServletClass" method="GET">
        <select name="SourceEnv" >      
            <option>10.100.10.11</option>      
            <option>10.100.10.12</option>      
        </select>  
       <select name="DestEnv" >      
            <option>10.100.10.11</option>      
            <option>10.100.10.12</option>      
        </select> 
<button type="submit" value="Submit">Submit</button> 
</form>
</body>
</html>