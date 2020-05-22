final int statusCode = httpResponse.getStatusLine().getStatusCode();
switch (statusCode)
{
    case 201:
        // Successfuly Registered
        break;
    case 400: 
        // Username Already taken
        break;
    default:
        break;
}