case "+":
if (temp.size() < 2) {
    System.out.println("There's not enough operands!");
    return;
}
one = (Integer) temp.pop();
two = (Integer) temp.pop();
result = one + two;
System.out.println(one + " + " + two);
temp.push(result);
break;