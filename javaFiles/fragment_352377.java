socket.Connect (lep);

// Using the RemoteEndPoint property.
Console.WriteLine ("I am connected to " + IPAddress.Parse (((IPEndPoint)socket.RemoteEndPoint).Address.ToString ()) + "on port number " + ((IPEndPoint)socket.RemoteEndPoint).Port.ToString ());

// Using the LocalEndPoint property.
Console.WriteLine ("My local IpAddress is :" + IPAddress.Parse (((IPEndPoint)socket.LocalEndPoint).Address.ToString ()) + "I am connected on port number " + ((IPEndPoint)socket.LocalEndPoint).Port.ToString ());