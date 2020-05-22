// Set up database stuff...

// Query the database
$query = sprintf("SELECT * FROM friends users WHERE username='%s' AND password='%s'",
         mysqli_real_escape_string($_GET["username"]),
         mysqli_real_escape_string($_GET["password"]));

if (($result = mysqli_query($query)) && ($row = mysqli_fetch_assoc($result))) {
    if ($row["license"] == "premium") {
        echo "welcome";
    } else {
        echo "shut up and pay me";
    }
} else {
    echo "no such user";
}