pushd 
setlocal

Set BIN_DIR=C:\Program Files\IKOffice_ACME\bin
Set GS=C:\Program Files\IKOffice_ACME\gs
Set GS_DLL=%GS%\gs8.54\bin\gsdll32.dll
Set GS_LIB=%GS%\gs8.54\lib;%GS%\gs8.54\Resource;%GS%\fonts
Set Path=%Path%;%GS%\gs8.54\bin
Set Path=%Path%;%GS%\gs8.54\lib

call "%GS%\gs8.54\bin\gswin32c.exe" -q -dSAFER -dNOPAUSE -dBATCH -sDEVICE#bmpmono -r600x600 -sOutputFile#%2 -f %1

endlocal
popd