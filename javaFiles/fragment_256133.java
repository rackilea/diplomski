ControlFocus("Open","","Edit1")
Global $files="",$appendquotes="",$j=2;
IF $cmdLine[0]==1 then
    $files=$CmdLine[1]
 ElseIf $cmdLine[0] > 1 Then
   For $i=1 to $cmdLine[1]
       $appendquotes='"' & $CmdLine[$j] & '"';
       $files=$files & " " & $appendquotes;
       $j=$j+1;
    Next
EndIf
ControlSetText('Open','','Edit1',$files)
ControlClick("Open","","Button1")