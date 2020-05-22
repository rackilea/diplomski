<%@page import="java.util.*"%>
<%@page language="java" session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%!
public class SumSet {
    public int Num1;
    public int Num2;
    public int Num3;

    public SumSet() {
        this.Num1 = 0;
        this.Num2 = 0;
        this.Num3 = 0;
    }

    public void add(NumberSet number) {
        if(number.Num1 != null && number.Num2 != null && number.Num3 != null) {
            this.Num1 += number.Num1.intValue();
            this.Num2 += number.Num2.intValue();
            this.Num3 += number.Num3.intValue();
        }
    }
}

public class NumberSet {
    public Integer Num1;
    public Integer Num2;
    public Integer Num3;

    public NumberSet() {}

    public NumberSet(String num1, String num2, String num3) {
        this.Num1 = Integer.parseInt(num1, 10);
        this.Num2 = Integer.parseInt(num2, 10);
        this.Num3 = Integer.parseInt(num3, 10);
    }
}
%>
<%
SumSet sum = new SumSet();

List<NumberSet> numbers = new ArrayList<NumberSet>();
String[] num1 = request.getParameterValues("num1");
String[] num2 = request.getParameterValues("num2");
String[] num3 = request.getParameterValues("num3");

if(num1 != null && num2 != null && num3 != null) {
    for(int v = 0; v < num1.length; v++) {
        try {
            numbers.add(new NumberSet(num1[v], num2[v], num3[v]));
        } catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
            //Skip invalid value
        }
    }
}
//Add some empty rows
numbers.add(new NumberSet());
numbers.add(new NumberSet());
numbers.add(new NumberSet());
%>
<html>
<head>
    <title>SO Example</title>
    <script>
        function AddRow() {
            document.getElementById('TableInputs').insertAdjacentHTML('beforeend',
                '<tr>'+
                    '<td><input type="text" name="num1" size="10"></td>'+
                    '<td><input type="text" name="num2" size="10"></td>'+
                    '<td><input type="text" name="num3" size="10"></td>'+
                '</tr>');
        }
    </script>
</head>
<body>
    <form method='POST' action='/so.jsp'>
        <table>
            <tbody id='TableInputs'>
            <% for(NumberSet number : numbers) {
                sum.add(number);%>
                <tr>
                    <td><input type="text" name="num1" size="10" value="<%=(number.Num1 != null ? number.Num1 : "")%>"></td>
                    <td><input type="text" name="num2" size="10" value="<%=(number.Num2 != null ? number.Num2 : "")%>"></td>
                    <td><input type="text" name="num3" size="10" value="<%=(number.Num3 != null ? number.Num3 : "")%>"></td>
                </tr>
            <%}%>
            </tbody>
            <tfoot>
                <tr>
                    <td><%=sum.Num1%></td>
                    <td><%=sum.Num2%></td>
                    <td><%=sum.Num3%></td>
                </tr>
            </tfoot>
        </table>
        <input type=submit>
        <button onclick='AddRow(); return false;'>Add Row</button>
    </form>
</body>
</html>