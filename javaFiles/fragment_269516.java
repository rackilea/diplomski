import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

import oauth.signpost.OAuth
import oauth.signpost.OAuthConsumer
import oauth.signpost.OAuthProvider
import oauth.signpost.basic.DefaultOAuthConsumer
import oauth.signpost.basic.DefaultOAuthProvider

api_url = "http://twitter.com/statuses/user_timeline.xml"
callback_url = "OOB"
provider = new DefaultOAuthConsumer(key, secret);
consumer = new DefaultOAuthProvider("http://twitter.com/oauth/request_token",
                         "http://twitter.com/oauth/access_token",
                         "http://twitter.com/oauth/authorize");

auth_url = provider.retrieveRequestToken(consumer, callback_url);

# Visit the auth_url and authorize that token manually

# oauth_verifier should be the digits returned by twitter for OOB authorization

provider.retrieveAccessToken(consumer, oauth_verifier);

access_token = consumer.getToken()
access_secret = consumer.getTokenSecrect()

# Finally, make your request...

url = new URL(api_url)

connection  = url.openConnection()

consumer.sign(connection)
connection.connect()

# In case you wanted to get the data/response.
response = connection.getResponseMessage()

reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))

line = ''
results = ''

while ((line = reader.readLine()) != NULL) {
      results += line;
    }
reader.close()