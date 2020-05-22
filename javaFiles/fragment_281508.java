[StructLayout(LayoutKind.Sequential, CharSet=CharSet.Unicode)]
internal class CRYPTUI_VIEWCERTIFICATE_STRUCTW
{
    internal uint dwSize;
    internal IntPtr hwndParent;
    internal uint dwFlags;
    internal string szTitle;
    internal IntPtr pCertContext;
    internal IntPtr rgszPurposes;
    internal uint cPurposes;
    internal IntPtr pCryptProviderData;
    internal bool fpCryptProviderDataTrustedUsage;
    internal uint idxSigner;
    internal uint idxCert;
    internal bool fCounterSigner;
    internal uint idxCounterSigner;
    internal uint cStores;
    internal IntPtr rghStores;
    internal uint cPropSheetPages;
    internal IntPtr rgPropSheetPages;
    internal uint nStartPage;
    public CRYPTUI_VIEWCERTIFICATE_STRUCTW();
}

[DllImport("cryptui.dll", CharSet=CharSet.Unicode, SetLastError=true)]
internal static extern bool CryptUIDlgViewCertificateW(
    [In, MarshalAs(UnmanagedType.LPStruct)] CRYPTUI_VIEWCERTIFICATE_STRUCTW ViewInfo, 
    [In, Out] IntPtr pfPropertiesChanged);