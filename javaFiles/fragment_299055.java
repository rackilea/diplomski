// assumption: socket is your C# socket
using(NetworkStream str = new NetworkStream(socket))
using(StreamWriter writer = new StreamWriter(str))
{
    foreach (string line in arrayOfStrings)
    {
        // This automatically appends a new line character to the end
        // of the line
        writer.WriteLine(line);
    }
}