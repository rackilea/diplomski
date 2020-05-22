Session s = new Session(...);
for(int i = 0; i < MAX_TRIES; i++) {
    try {
       s.connect();
       break;
    }
    catch(JSchException ex) {
       if(i == MAX_TRIES - 1)
           throw ex;
       continue;
    }
}