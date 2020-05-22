extern "C" __declspec( dllexport )
void __stdcall GetInfo(InfoProvider* infoProvider, Info* info)
{
   static_assert(std::is_pod<Info>::value, "Must be Plain Old Data in order to be safely copied between DLL boundaries");

   Info infoProvider = GetInfo(infoProvider);
   info->data1 = infoProvider.data1;
   info->data2 = infoProvider.data2;
}