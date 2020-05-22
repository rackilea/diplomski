//create payload
Map<String, Object> payload = new HashMap<>();
payload.put("iss", "orgId");
payload.put("sub", "orgId");
payload.put("exp", "orgId");
payload.put("aud", new
StringBuilder("Url").append("/c/").append("key").toString());
payload.put(new StringBuilder("Url").append("/s/entt_sdk").toString(), Boolean.TRUE);

// read key
String privateKeyB64 = Files.lines(Paths.get("src/main/resources/private.key")).collect(Collectors.joining());
byte[] privateKeyDecoded = Base64.getDecoder()
                .decode(privateKeyB64);

//create key spec
PKCS8EncodedKeySpec spec =
                new PKCS8EncodedKeySpec(privateKeyDecoded);

// create key form spec
KeyFactory keyFactory = KeyFactory.getInstance("RSA");
PrivateKey privateKey = keyFactory.generatePrivate(spec);

//create signed JWT - JWS
String jws = Jwts.builder().setClaims(payload).signWith(SignatureAlgorithm.RS256, privateKey).compact();

System.out.println(jws);