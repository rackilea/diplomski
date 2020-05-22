public String createToken( Email mail )
  {
      Claims claims = Jwts.claims().setSubject( String.valueOf( mail.getId() ) );
        claims.put( "mailId", mail.getId() );
        Date currentTime = new Date();
        currentTime.setTime( currentTime.getTime() + tokenExpiration * 60000 );
        return Jwts.builder()
          .setClaims( claims )
          .setExpiration( currentTime )
          .signWith( SignatureAlgorithm.HS512, salt.getBytes() )
          .compact();
  }