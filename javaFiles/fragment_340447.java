<html>
  <body>
    $name is $age years old and lives $address.streetAddress, ${address.city}.
    <br/>
    $name's friends:
    <ul>
    #foreach($friend in $friends)
      <li>$friend.name, who is $friend.age years old</li>
    #end
    </ul>
  </body>
</html>