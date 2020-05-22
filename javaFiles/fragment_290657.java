ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
String msg= "";
while (it.hasNext())
{
   msg = new String(it.next().message());
   System.out.println("Thread " + m_threadNumber + ": " + msg);
}