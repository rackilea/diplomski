ObjectMapper mapper = new ObjectMapper();
     A a = new A(a1,a2,an);
     B b = new B(b1,b2,bn);
     ..
     .. so on..
     TopLevel top= new TopLevel(a, b, c,........so on);
     String jsonWriter = mapper.writerWithDefaultPrettyPrinter()
         .writeValueAsString(top);
     System.out.println(jsonWriter);