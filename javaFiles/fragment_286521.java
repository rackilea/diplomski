Dim a = {"a", Nothing, "", "b"}

' this will print from 0 to 1, but Array.IndexOf returns -1 if value is not found
For i = 0 To Array.IndexOf(a, "") - 1
    Debug.Print(i & "")
Next

For Each item In a : If item = "" Then Exit For ' this is actually 2 lines separated by : 
    Debug.Print("'{0}'", item)
Next

For Each item In a.TakeWhile(Function(s) s > "") ' TakeWhile is a System.Linq extension
    Debug.Print("'{0}'", item)
Next

a.TakeWhile(Function(s) s > "").ToList.ForEach(AddressOf Debug.Print) ' prints a

a.TakeWhile(Function(s) s > "").ToList.ForEach(Sub(s) Debug.Print(s)) ' prints a