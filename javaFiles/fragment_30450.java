@GetMapping("/persons")
        public ResponseEntity loadPersons(@RequestParam("access_token") String access_token,HttpServletRequest request){
         //Here you can play with the token now 

        //you can also get the token if it is coming with request header as follows :
           String token =request.getHeader("access_token");//replace with the specific key

        }