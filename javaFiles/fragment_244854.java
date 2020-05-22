public interface User32 extends Library {

  public static User32 INSTANCE = (User32) Native
      .loadLibrary("User32", User32.class);

  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_ARROW = 32512;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_IBEAM = 32513;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_WAIT = 32514;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_CROSS = 32515;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_UPARROW = 32516;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_SIZENWSE = 32642;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_SIZENESW = 32643;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_SIZEWE = 32644;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_SIZENS = 32645;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_SIZEALL = 32646;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_NO = 32648;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_HAND = 32649;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_APPSTARTING = 32650;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_HELP = 32651;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_ICON = 32641;
  /** @see #LoadCursorW(Pointer, int) */
  public static final int IDC_SIZE = 32640;

  /** @see #DrawIconEx(Pointer, int, int, Pointer, int, int, int, Pointer, int) */
  public static final int DI_COMPAT = 4;
  /** @see #DrawIconEx(Pointer, int, int, Pointer, int, int, int, Pointer, int) */
  public static final int DI_DEFAULTSIZE = 8;
  /** @see #DrawIconEx(Pointer, int, int, Pointer, int, int, int, Pointer, int) */
  public static final int DI_IMAGE = 2;
  /** @see #DrawIconEx(Pointer, int, int, Pointer, int, int, int, Pointer, int) */
  public static final int DI_MASK = 1;
  /** @see #DrawIconEx(Pointer, int, int, Pointer, int, int, int, Pointer, int) */
  public static final int DI_NORMAL = 3;
  /** @see #DrawIconEx(Pointer, int, int, Pointer, int, int, int, Pointer, int) */
  public static final int DI_APPBANDING = 1;

  /** http://msdn.microsoft.com/en-us/library/ms648391(VS.85).aspx */
  public Pointer LoadCursorW(Pointer hInstance,
      int lpCursorName);

  /** http://msdn.microsoft.com/en-us/library/ms648065(VS.85).aspx */
  public boolean DrawIconEx(Pointer hdc, int xLeft,
      int yTop, Pointer hIcon, int cxWidth, int cyWidth,
      int istepIfAniCur, Pointer hbrFlickerFreeDraw,
      int diFlags);

}