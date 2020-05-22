ctx = new SHA512Managed();

byte[] digestA = new byte[key.Length + salt.Length];

ctx.TransformBlock(key, 0, key.Length, digestA, 0);
ctx.TransformBlock(salt, 0, salt.Length, digestA, key.Length);

byte[] digestB = new byte[key.Length * 2 + salt.Length];

ctx.TransformBlock(key, 0, key.Length, digestB, 0);
ctx.TransformBlock(salt, 0, salt.Length, digestB, key.Length);
ctx.TransformBlock(key, 0, key.Length, digestB, key.Length + salt.Length);

alt_ctx = new SHA512Managed();

alt_result = alt_ctx.ComputeHash(digestB);