<cfscript>
    var pass = "a_password";
    javaLoader = server[Application.str.myJavaLoaderKey];
    // create an instance of javaloader-BCrypt
    bcrypt = javaLoader.create("BCrypt").init();
    // now you can call methods from bcrypt like so:
    hashed = bcrypt.hashpw(pass, bcrypt.gensalt());
</cfscript>