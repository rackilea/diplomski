public static long windowProc( long hwnd, long msg, long wparam, long lParam )
{
    if( msg == 'My device event id' )
    {
        //process it & return 1;
    }
    return OS.CallWindowProc( SpaceMouseServiceImpl.oldWinProc, hwnd, (int) msg, wparam, lParam );
}