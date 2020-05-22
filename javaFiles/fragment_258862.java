import java.security.cert.*
import javax.net.ssl.*

TrustManager[] trustAllCerts = [
    [ getAcceptedIssuers: { -> null },
      checkClientTrusted: { X509Certificate[] certs, String authType -> },
      checkServerTrusted: { X509Certificate[] certs, String authType -> } ] as X509TrustManager
]