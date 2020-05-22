1128       /**
 1129        * Encode the session identifier associated with this response
 1130        * into the specified redirect URL, if necessary.
 1131        *
 1132        * @param url URL to be encoded
 1133        */
 1134       public String encodeRedirectURL(String url) {
 1135   
 1136           if (isEncodeable(toAbsolute(url))) {
 1137               return (toEncoded(url, request.getSessionInternal().getIdInternal()));
 1138           } else {
 1139               return (url);
 1140           }
 1141   
 1142       }