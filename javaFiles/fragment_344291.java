public String readMailIdFromToken( String token )
  {
    Jwts.parser().setSigningKey( salt.getBytes() ).parseClaimsJws( token ).getSignature();
    Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey( salt.getBytes() ).parseClaimsJws( token );        
    return parseClaimsJws.getBody().getSubject();
  }