Private Sub Worksheet_Change(ByVal Target As Range){
    If Range(ActiveCell.Address).Validation.Parent = "33" Then
        ActiveSheet.Unprotect
        Range("$B$" & ActiveCell.Row).Locked = True
        Range("$C$" & ActiveCell.Row).Locked = False
        ActiveSheet.Protect
    ElseIf Range(ActiveCell.Address).Validation.Parent = "23" Then
        ActiveSheet.Unprotect
        MsgBox ActiveCell.Address
        Range("$C$" & ActiveCell.Row).Locked = True
        Range("$B$" & ActiveCell.Row).Locked = False
        ActiveSheet.Protect
    Else
        ActiveSheet.Unprotect
        Range("$C$" & ActiveCell.Row).Locked = True
        Range("$B$" & ActiveCell.Row).Locked = True
        ActiveSheet.Protect
    End If
End Sub