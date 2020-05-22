public interface Gdi32 extends Library {

  public static Gdi32 INSTANCE = (Gdi32) Native
      .loadLibrary("Gdi32", Gdi32.class);

  /** http://msdn.microsoft.com/en-us/library/dd183489(VS.85).aspx */
  public Pointer CreateCompatibleDC(Pointer hdc);

  /** http://msdn.microsoft.com/en-us/library/dd183488(VS.85).aspx */
  public Pointer CreateCompatibleBitmap(Pointer hdc,
      int nWidth, int nHeight);

  /** http://msdn.microsoft.com/en-us/library/dd162957(VS.85).aspx */
  public Pointer SelectObject(Pointer hdc, Pointer hgdiobj);

  /** http://msdn.microsoft.com/en-us/library/dd145078(VS.85).aspx */
  public int SetPixel(Pointer hdc, int X, int Y, int crColor);

  /** http://msdn.microsoft.com/en-us/library/dd144909(VS.85).aspx */
  public int GetPixel(Pointer hdc, int nXPos, int nYPos);

  /** http://msdn.microsoft.com/en-us/library/dd183539(VS.85).aspx */
  public boolean DeleteObject(Pointer hObject);

  /** http://msdn.microsoft.com/en-us/library/dd183533(VS.85).aspx */
  public boolean DeleteDC(Pointer hdc);

}