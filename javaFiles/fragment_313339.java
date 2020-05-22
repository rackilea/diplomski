if (tokenStore.validateToken(decoded.getUsername(), decoded.getValue()))
        {
           credentials.setUsername(decoded.getUsername());
           credentials.setPassword(decoded.getValue());               
        }
        else
        {
           // Have we been compromised? Just in case, invalidate all authentication tokens
           tokenStore.invalidateAll(decoded.getUsername());
        }