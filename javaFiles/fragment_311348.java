LPTSTR str_settings = new TCHAR[bufferSize];

::GetPrivateProfileSection(_T("MySection"), str_settings , bufferSize, _T("MyIni.ini"));

std::map<std::string, std::string> settings; // map key -> value from ini file
std::string sett_string;

for (;*str_settings; str_settings += sett_string.length() + 1)
{
   sett_string = str_settings;

   size_t pos = sett_string.find('=');
   std::string key;
   std::string value;

   if (pos == std::string::npos)
   {
      key = sett_string;
   }
   else
   {
      key.assign(sett_string.begin(), sett_string.begin() + pos);
      value.assign(sett_string.begin() + pos + 1, sett_string.end());
   }

   settings[key] = value;
}