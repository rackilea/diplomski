Sub Click(Source As Button)
    Dim javaSession As New JAVASESSION
    Dim javaError As JAVAERROR

    On Error Goto ErrorHandling

    Dim logWSDTOClass As JAVACLASS
    Dim logWSDTOObject As JavaObject

    Dim logWebServiceClass As JAVACLASS
    Dim logWebServiceObject As JavaObject

    Set logWSDTOClass = javaSession.getClass("com/pasquier/IDAO/WS/LogWSDTO")
    Set logWSDTOObject = logWSDTOClass.CreateObject()

    Set logWebServiceClass = javaSession.getClass("com/pasquier/IDAO/WS/LogWebService")

    'Does not work, but should 
    'Set logWebServiceObject = logWebServiceClass.CreateObject("(Lcom/pasquier/IDAO/WS/LogWSDTO;)V", logWSDTOObject)

    'workaround
    Set logWebServiceObject = logWebServiceClass.CreateObject()
    Call logWebServiceObject.setLog(logWSDTOObject)
    Call logWebServiceObject.notesMain()

    Msgbox "done"

    Exit Sub
ErrorHandling:
    Msgbox Error '
    Set javaError = javaSession.getLastJavaError
    Msgbox "Java error: " + javaError.ErrorMsg 
End Sub