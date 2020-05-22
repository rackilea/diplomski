extern "C" __declspec( dllexport )
void __stdcall FreeInfo(Info* info)
{
   static_assert(std::is_pod<Info>::value, "Must be Plain Old Data in order to be safely copied between DLL boundaries");

   delete info;
}