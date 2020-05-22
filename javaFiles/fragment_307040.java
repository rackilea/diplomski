String token = request.getHeader(HEADER_STRING);

if (StringUtils.isNotBlank(token)){
    String user = Jwts.parser()
        .setSigningKey(SECRET.getBytes())
        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
        .getBody()
        .getSubject();

    if (StringUtils.isNotBlank(user)){
        return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
    }