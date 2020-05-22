String aws_cognito_region = "us-east-1"; // Replace this with your aws cognito region
String aws_user_pools_id = "us-east-1_7DEw1nt5r"; // Replace this with your aws user pools id
RSAKeyProvider keyProvider = new AwsCognitoRSAKeyProvider(aws_cognito_region, aws_user_pools_id);
Algorithm algorithm = Algorithm.RSA256(keyProvider);
JWTVerifier jwtVerifier = JWT.require(algorithm)
    //.withAudience("2qm9sgg2kh21masuas88vjc9se") // Validate your apps audience if needed
    .build();

String token = "eyJraWQiOiJjdE.eyJzdWIiOiI5NTMxN2E.VX819z1A1rJij2"; // Replace this with your JWT token
jwtVerifier.verify(token);