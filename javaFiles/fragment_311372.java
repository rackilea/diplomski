Issue the "what you should enter" message
Initialize any needed counters
begin the loop (while counters < value?)
   // use try catch to surround your input and calculations to catch malformed integers etc
   try {
       get candidate data element from input stream
       check for validity
         if success increment count, do other needed work
         if fail, reissue "what you should enter" message or more specific error message
   } catch malformed input {
         reissue "what you shoue enter" message, including error for malformed input
   }
end loop