int pointer = 0;
for(boolean running = true; running && pointer < lines.size(); ) {
   String line = lines.get(pointer);
   String[] parts = line.split(" +");
   switch(part[0]) {
      case "JMP":
          pointer += Integer.parseInt(parts[1]); // jump back or forth.
          continue;
      case "HALT":
          running = false;
          break;
      // other instructions
   }
   pointer++;
}