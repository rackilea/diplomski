@GetMapping(value = ..., produces = "application/pdf")
   //return a "view name" (!), and you can inject (only) the outputstream (without enclosing response) 
   public String generatePdf(java.io.OutputStream outputstream) throws... {          
      // ... do your things on outputstream, IOUtils is good...
      // close the stream(?)
      // ..and
      return "redirect:/"; // to a redirect or a view name.
      // .... (in a "spring way", which could also save you some "context path problems"
   } ...