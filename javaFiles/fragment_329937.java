import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CacheResourceHandler extends ResourceHttpRequestHandler {

        private Map<URL, byte[]> cache = new HashMap<>();

        @Override
        protected void writeContent(HttpServletResponse resp, Resource rsc) throws IOException {
            byte[] buff = cache.get(rsc.getURL());

            //if not in cache
            if (buff == null) {
                //add to cache
                buff = StreamUtils.copyToByteArray(rsc.getInputStream());
                cache.put(rsc.getURL(), buff);
            }

            //return cache version
            StreamUtils.copy(buff, resp.getOutputStream());
        }

    }