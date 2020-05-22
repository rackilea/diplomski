# Create a user agent object
 use LWP::UserAgent;
 my $ua = LWP::UserAgent->new;

 # Create a request
 my $req = HTTP::Request->new(POST => $url);
 $req->content_type('application/x-www-form-urlencoded');

 # cookies 
 $ua->cookie_jar({ file => "$ENV{HOME}/.cookies.txt" });

 # Pass request to the user agent and get a response back
 my $res = $ua->request($req);

 # Check the outcome of the response
 if ($res->is_success) {
    print $res->content;
 } else {
    print $res->status_line, "\n";
 }