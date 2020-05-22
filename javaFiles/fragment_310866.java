1159       /**
 1160        * Encode the session identifier associated with this response
 1161        * into the specified URL, if necessary.
 1162        *
 1163        * @param url URL to be encoded
 1164        */
 1165       public String encodeURL(String url) {
 1166           
 1167           String absolute = toAbsolute(url);
 1168           if (isEncodeable(absolute)) {
 1169               // W3c spec clearly said 
 1170               if (url.equalsIgnoreCase("")){
 1171                   url = absolute;
 1172               }
 1173               return (toEncoded(url, request.getSessionInternal().getIdInternal()));
 1174           } else {
 1175               return (url);
 1176           }
 1177   
 1178       }