RSASSA-PSS-params ::= SEQUENCE {
   hashAlgorithm      [0] OAEP-PSSDigestAlgorithms  DEFAULT sha1,
   maskGenAlgorithm   [1] PKCS1MGFAlgorithms  DEFAULT mgf1SHA1,
   saltLength         [2] INTEGER  DEFAULT 20,
   trailerField       [3] INTEGER  DEFAULT 1
 }