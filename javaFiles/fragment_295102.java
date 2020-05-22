// Request
stringstream ss;
string endline = "\r\n";

ss << "POST /gcm/send HTTP/1.0" << endline;
ss << "Host: android.googleapis.com" << endline;
ss << "Accept: */*" << endline;
ss << "Authorization: key=" << mKey << endline;
ss << "Content-Type: application/json" << endline;
ss << "Content-Length: " << ssbody.str().size() << endline;
ss << endline;
ss << ssbody.str();

syslog(LOG_DEBUG, "%s", ss.str().c_str());

int bioResult = 0;
do {
    bioResult = BIO_write(mBio, ss.str().c_str(), ss.str().length());
    if (bioResult <= 0) {
        this->restart();
    }
} while (bioResult <= 0);