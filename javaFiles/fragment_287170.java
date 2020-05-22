package stackoverflow.answer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

public class JenkinsPoster {
    final Logger log = Logger.getLogger(getClass().getCanonicalName());
    private JobData jd;

    public JenkinsPoster(JobData jobData) {
        this.jd = jobData;
    }

    @SuppressWarnings("deprecation")
    public void postJenkinsJob() throws UnsupportedEncodingException {
        log.entering(getClass().getCanonicalName(), "JenkinsPoster");
        // Jenkins url
        String jenkinsUrl = String.format("%s:%s/jenkins", jd.getServer(), jd.getPort());
        log.info("url = " + jenkinsUrl);
        // Create your httpclient
        DefaultHttpClient client = new DefaultHttpClient();
        // Then provide the right credentials
        client.getCredentialsProvider().setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
        new UsernamePasswordCredentials(jd.getUsername(), jd.getPassword()));
        // Generate BASIC scheme object and stick it to the execution context
        BasicScheme basicAuth = new BasicScheme();
        BasicHttpContext context = new BasicHttpContext();
        context.setAttribute("preemptive-auth", basicAuth);
        // Add as the first (because of the zero) request interceptor
        // It will first intercept the request and preemptively initialize the authentication scheme if there is not
        client.addRequestInterceptor(new PreemptiveAuth(), 0);

        // Post the request to start the build
        List<NameValuePair> parameters = jd.getParameters();
        UrlEncodedFormEntity uefe = null;
        String buildUrl = "";
        if (parameters.isEmpty()) {
            buildUrl = jenkinsUrl + "/job/" + jd.getJob() + "/build";
        }
        else {
            buildUrl = jenkinsUrl + "/job/" + jd.getJob() + "/buildWithParameters";
            uefe = new UrlEncodedFormEntity(parameters);
        }
        HttpPost post = new HttpPost(buildUrl);
        post.setHeader("User-Agent", "Mozilla/5.0");
        if (uefe != null) {
            post.setEntity(uefe);
        }

        try {
            // Execute your request with the given context
            HttpResponse response = client.execute(post, context);
            HttpEntity entity = response.getEntity();
            log.info(EntityUtils.toString(entity));
            EntityUtils.consume(entity);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            client.close();
        }
        log.exiting(getClass().getCanonicalName(), "JenkinsPoster");
    }
}