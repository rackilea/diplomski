Sub Click(Source As Button)
    Dim mySession As JAVASESSION    
    Dim utilDate As JAVACLASS
    Dim objUtilDate As JAVAOBJECT
    Dim toto As String
    Dim toto2 As String
    Dim myMCollection As JavaMethodCollection
    Dim myMethod As JavaMethod
    Dim methodJava As JavaMethod
    toto2 = "test"

    Set mySession = New  JAVASESSION    
    Set utilDate = mySession.GetClass("test/UtilEssai") 
    Set objUtilDate = utilDate.CreateObject


    Messagebox (toto2)

    Set myMCollection = utilDate.getClassMethods()

    Set myMethod = myMCollection.getFirst()
    Do
        If myMCollection.count <> 0 Then    
            toto2 =  myMethod.MethodName & " " & myMethod.signature
            Messagebox (toto2)

            If myMethod.MethodName = "essaiMethode" Then
                Set methodJava = utilDate.GetMethod("essaiMethode","()Ljava/lang/String;")
                toto = methodJava.Invoke(objUtilDate)           
                Messagebox (toto)
            End If

        End If
        Set myMethod = myMCollection.getNext()      
    Loop While myMCollection.current <> 1



End Sub