// aLine is just a single line
while((aLine = in.readLine()) != null) {
     n.reset(aLine);
     // yet you want to replace a multi-line pattern
     String result = n.replaceAll("");
     out.write(result);
     out.newLine();
}