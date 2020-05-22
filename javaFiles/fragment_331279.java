$statement = mysqli_prepare($con, "SELECT username, email, password FROM user WHERE username = ? AND password = ? LIMIT 1");
    //Change username, email, password to whatever the equivalent are in the database if they are different. 
The Limit 1 also limits you to only 1 record that matches that criteria, which should be the case anyway, but prevents it from running through the whole database.
        mysqli_stmt_bind_param($statement, "ss", $username, $password);
        mysqli_stmt_execute($statement);

        mysqli_stmt_store_result($statement);
        mysqli_stmt_bind_result($statement, $username,$email, $password);