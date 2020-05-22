StringBuilder total = new StringBuilder();

for (int i = 0; i < input.length(); i += 2){
    total.append(input.charAt(i));
}
System.out.println(total.toString());