import java.xml.ws.http.HTTPException; 

try {     
    validateUser(a,b); 
} catch(HTTPException he){     
    response = new ResponseEntity<>(HttpStatus.valueOf(he.getStatusCode())); 
}

private void validateUser(String a, String b) throws HTTPException {     
    if(some condition) {         
        throw new HTTPException(HttpStatus.UNAUTHORIZED.value());      
    } 
}