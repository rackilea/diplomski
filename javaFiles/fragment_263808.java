// ...
StringBuilder sb = new StringBuilder();
while((line = in.readLine()) != null && line.length()!= 0)  {
    sb.append(line);
}
in.close();

System.out.println(sb.reverse().toString());

// ...