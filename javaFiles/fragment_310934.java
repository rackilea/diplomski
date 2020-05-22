public class KeyStrokeBuffer
{
  private CharBuffer buffer;
  private static final int BUFFER_SIZE = 5;

  Scanner sc;

  public KeyStrokeBuffer ()
  {
    this.buffer  = CharBuffer.allocate(BUFFER_SIZE);
    sc = new Scanner(System.in);
  }

  public void add (String s){
    int pointer = 0;
    while (pointer < s.length() &&  buffer.length() >0){
        buffer.put (s.charAt(pointer));
        pointer++;
        s.substring(1);
    }
    if (pointer != s.length()) { //This is for make the string sended always in the same size
        cipher (buffer); //This launched like a synchronized thread 
        buffer = CharBuffer.allocate(BUFFER_SIZE); 
        add(s);
    }
  }

  public void cipher (CharBuffer buffer){
    System.out.println ("Dentro cypher");
  }