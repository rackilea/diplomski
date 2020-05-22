// in your loop
if (Bracket.isStarter(currentCharacter)) {
  stack.push(new Bracket(currentLocation, currentCharacter));
} else {
   if (stack.peek().matches(currentCharacter))
     stack.pop();
   else {
     Bracket b = stack.pop();
     System.out.println("Mismatch error " + b.getBracket() + 
       " at character position " + b.getLoc() + 
       " followed by a " + currentCharacter + 
       " at position " + currentPosition + ".");
   }
} // something on this order at least