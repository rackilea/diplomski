void setup()
{
    size(300, 400);
    try
    {/* now you are using the field socket1 and not a local socket1 */
        socket1 = new ServerSocket(main_port);
    }
   catch (Exception g) { }
}